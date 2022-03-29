import javafx.geometry.HPos
import javafx.geometry.Insets
import tornadofx.*

class StartScreenView : View() {
    override val root = gridpane {
        addClass(Styles.background)
        row {
            label("Restaurant\nRecommender") {
                addClass(Styles.startTitleText)
                gridpaneConstraints {
                    margin = Insets(32.0)
                    hAlignment = HPos.CENTER
                }
            }
        }
        row {
            imageview("food-icon-small.png") {
                gridpaneConstraints {
                    hAlignment = HPos.CENTER
                }
            }
            addClass(Styles.startImage)
        }
        row {
            button("Start") {
                addClass(Styles.startButton)
                action {
                    this@StartScreenView.replaceWith(FoodSurveyView::class, centerOnScreen = true)
                }
                gridpaneConstraints {
                    margin = Insets(80.0)
                    hAlignment = HPos.CENTER
                }
            }
        }
    }
}