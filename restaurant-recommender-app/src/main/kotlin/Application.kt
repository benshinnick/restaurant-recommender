import javafx.stage.Stage
import tornadofx.*

class Application: App(StartScreenView::class, Styles::class) {

    override fun start(stage: Stage) {
        super.start(stage)
        stage.width = 400.0
        stage.height = 700.0
        stage.centerOnScreen()
    }

    init {
        reloadStylesheetsOnFocus()
    }

    fun main(args: Array<String>) {
        launch<Application>(args)
    }
}