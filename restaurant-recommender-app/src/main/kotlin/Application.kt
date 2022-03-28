import tornadofx.*

class Application: App(MyView::class) {
    fun main(args: Array<String>) {
        launch<Application>(args)
    }
}