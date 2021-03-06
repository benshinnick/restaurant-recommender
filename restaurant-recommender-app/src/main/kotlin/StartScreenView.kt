import javafx.geometry.HPos
import javafx.geometry.Insets
import tornadofx.*

class StartScreenView : View() {
    override val root = gridpane {
        addClass(Styles.background)
        row {
            label("Restaurant\nRecommender") {
                addClass(Styles.startTitleText)
                gridpaneConstraints { margin = Insets(32.0); hAlignment = HPos.CENTER }
            }
        }
        row {
            addClass(Styles.startImage)
            imageview("food-icon-small.png") {
                gridpaneConstraints {  hAlignment = HPos.CENTER }
            }
        }
        row {
            button("Start") {
                addClass(Styles.startButton)
                action { startButtonOnClick() }
                gridpaneConstraints { margin = Insets(80.0); hAlignment = HPos.CENTER }
            }
        }
    }

    private fun startButtonOnClick() {
        replaceWith<FoodSurveyView>(centerOnScreen = true)
    }
}