import javafx.scene.effect.BlurType
import javafx.scene.effect.DropShadow
import javafx.scene.paint.Color
import javafx.scene.text.TextAlignment
import tornadofx.*

class Styles: Stylesheet() {

    companion object {
        val background by cssclass()

        val startTitleText by cssclass()
        val startImage by cssclass()
        val startButton by cssclass()

        val foodSurveyScrollPane by cssclass()
        val foodSurveyTitleText by cssclass()
        val backButton by cssclass()
        val submitButton by cssclass()

        val recommendationsTitleText by cssclass()
        val restaurantInfoDisplay by cssclass()
        val restaurantInfoText by cssclass()
        val newRecommendationButton by cssclass()
        val selectRecommendationButton by cssclass()
        val neverButton by cssclass()
        val backToStartButton by cssclass()
    }

    init {
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

        startImage {
            effect = DropShadow(BlurType.GAUSSIAN, Color.WHITE, 4.0, 0.5, 0.0, 0.0)
        }

        startButton {
            backgroundColor += Color.GREEN
            textFill = Color.WHITE
            prefWidth = 100.px
            prefHeight = 50.px
            fontFamily = "Arial"
            fontSize = 20.px
        }

        foodSurveyTitleText {
            fontFamily = "Arial"
            textFill = Color.WHITE
            fontSize = 50.px
            textAlignment = TextAlignment.CENTER
        }

        foodSurveyScrollPane {
            minWidth = 350.px
        }

        backButton {
            backgroundColor += Color.DARKRED
            textFill = Color.WHITE
            prefWidth = 75.px
            prefHeight = 25.px
            fontFamily = "Arial"
            fontSize = 15.px
        }

        submitButton {
            backgroundColor += Color.GREEN
            textFill = Color.WHITE
            prefWidth = 75.px
            prefHeight = 25.px
            fontFamily = "Arial"
            fontSize = 15.px
        }

        recommendationsTitleText {
            prefWidth = 400.px
            fontFamily = "Arial"
            textFill = Color.WHITE
            fontSize = 41.px
            textAlignment = TextAlignment.CENTER
        }

        restaurantInfoDisplay {
            prefHeight = 350.px
        }

        restaurantInfoText {
            fontFamily = "Arial"
            textFill = Color.WHITE
            fontSize = 20.px
            textAlignment = TextAlignment.LEFT
            wrapText = true
        }

        newRecommendationButton {
            backgroundColor += Color.GREEN
            textFill = Color.WHITE
            prefWidth = 250.px
            prefHeight = 50.px
            fontFamily = "Arial"
            fontSize = 20.px
        }

        selectRecommendationButton {
            backgroundColor += Color.GREEN
            textFill = Color.WHITE
            prefWidth = 120.px
            prefHeight = 50.px
            fontFamily = "Arial"
            fontSize = 20.px
        }

        neverButton {
            backgroundColor += Color.DARKRED
            textFill = Color.WHITE
            prefWidth = 120.px
            prefHeight = 50.px
            fontFamily = "Arial"
            fontSize = 20.px
        }

        backToStartButton {
            backgroundColor += Color.GREEN
            textFill = Color.WHITE
            prefWidth = 250.px
            prefHeight = 50.px
            fontFamily = "Arial"
            fontSize = 20.px
        }
    }
}