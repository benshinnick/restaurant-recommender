import javafx.scene.paint.Color
import javafx.scene.text.TextAlignment
import tornadofx.*

class Styles: Stylesheet() {

    companion object {
        val startButton by cssclass()
        val startTitleText by cssclass()
    }

    init {
        startTitleText {
            fontFamily = "Arial"
            fontSize = 50.px
            minWidth = 330.px
            textAlignment = TextAlignment.CENTER;
        }

        startButton {
            fontFamily = "Arial"
            fontSize = 20.px
        }
    }
}