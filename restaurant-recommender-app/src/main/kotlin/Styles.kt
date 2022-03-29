import javafx.scene.paint.Color
import javafx.scene.text.TextAlignment
import tornadofx.*

class Styles: Stylesheet() {

    companion object {
        val background by cssclass()
        val startButton by cssclass()
        val backButton by cssclass()
        val startTitleText by cssclass()
        val foodSurveyTitleText by cssclass()
    }

    init {
        background {
            backgroundColor += c("#242930")
        }

        startTitleText {
            fontFamily = "Arial"
            fontSize = 50.px
            minWidth = 330.px
            textAlignment = TextAlignment.CENTER
            textFill = Color.WHITE
        }

        startButton {
            fontFamily = "Arial"
            fontSize = 20.px
        }

        backButton {
            fontFamily = "Arial"
            fontSize = 20.px
        }

        foodSurveyTitleText {
            fontFamily = "Arial"
            textFill = Color.WHITE
            fontSize = 50.px
            minWidth = 330.px
            textAlignment = TextAlignment.CENTER
        }
    }
}