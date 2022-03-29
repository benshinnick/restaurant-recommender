import javafx.scene.effect.BlurType
import javafx.scene.effect.DropShadow
import javafx.scene.paint.Color
import javafx.scene.text.TextAlignment
import tornadofx.*
import java.net.URI

class Styles: Stylesheet() {

    companion object {
        val background by cssclass()
        val startImage by cssclass()
        val startButton by cssclass()
        val backButton by cssclass()
        val startTitleText by cssclass()
        val foodSurveyTitleText by cssclass()
    }

    init {
        startImage {
            effect = DropShadow(BlurType.GAUSSIAN, Color.WHITE, 4.0, 0.5, 0.0, 0.0)
        }
        background {
            minWidth = 400.px
            maxWidth = 400.px
            backgroundColor += c("#242930")
        }

        startTitleText {
            fontFamily = "Arial"
            fontSize = 50.px
            textAlignment = TextAlignment.CENTER
            textFill = Color.WHITE
        }

        startButton {
            backgroundColor += Color.GREEN
            textFill = Color.WHITE
            prefWidth = 100.px
            prefHeight = 50.px
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