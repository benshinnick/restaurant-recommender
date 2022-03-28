import javafx.geometry.HPos
import tornadofx.*

class StartScreenView : View() {
    override val root = gridpane {
        row {
            text("Restaurant\nRecommender") {
                addClass(Styles.startTitleText)
                gridpaneConstraints {
                    marginTop = 55.0
                    marginLeft = 35.0
                    marginRight = 35.0
                    columnSpan = 1
                    hAlignment = HPos.CENTER
                }
            }
        }
        row {
            button("Start") {
                addClass(Styles.startButton)
                action {
                    this@StartScreenView.replaceWith(FoodSurveyView::class, centerOnScreen = true)
                }
                gridpaneConstraints {
                    marginTop = 250.0
                    columnSpan = 1
                    hAlignment = HPos.CENTER
                }
            }
        }
    }
}