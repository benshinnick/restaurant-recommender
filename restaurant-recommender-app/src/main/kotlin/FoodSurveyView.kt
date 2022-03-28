import javafx.geometry.HPos
import tornadofx.*

class FoodSurveyView : View() {
    override val root = gridpane {
        row {
            text("Food Survey") {
                addClass(Styles.startTitleText)
                gridpaneConstraints {
                    marginTop = 55.0
                    marginLeft = 55.0
                    marginRight = 55.0
                    columnSpan = 1
                    hAlignment = HPos.CENTER
                }
            }
        }
        row {
            button("Back") {
                addClass(Styles.startButton)
                action {
                    this@FoodSurveyView.replaceWith(StartScreenView::class, centerOnScreen = true)

                }
                gridpaneConstraints {
                    marginTop = 308.0
                    columnSpan = 1
                    hAlignment = HPos.CENTER
                }
            }
        }
    }
}