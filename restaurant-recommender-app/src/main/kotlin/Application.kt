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
        val r1 = Recommender()
        for (temp in r1.temps)
            for (t in temp.time)
                println(t)

        val r2 = Recommender()
        for (temp in r2.temps)
            for (t in temp.time)
                println(t)

        r1.valueCheck(r2)

        for (temp in r1.temps)
            for (t in temp.time)
                println(t)

        for (temp in r2.temps)
            for (t in temp.time)
                println(t)
    }
}