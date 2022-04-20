import javafx.stage.Stage
import tornadofx.*
import kotlin.system.exitProcess

class Application: App(StartScreenView::class, Styles::class) {

    override fun stop() {
        println("Closing Application")
        exitProcess(0)
    }

    override fun start(stage: Stage) {
        super.start(stage)
        stage.width = 400.0
        stage.height = 700.0
        stage.isResizable = false
        stage.centerOnScreen()
    }

    init {
        reloadStylesheetsOnFocus()
    }

    fun main(args: Array<String>) {
        //launch<Application>(args)
        val rest = RestData()
        val r1 = Recommender(rest)
        val arr = arrayOf(3,4,2,1,2,3)
        r1.generateRecommendations(arr, 2)
        while (r1.hasNext()) {
            println(r1.getNextRecommendation()?.name)
        }
    }
}