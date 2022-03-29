import javafx.geometry.HPos
import tornadofx.*

class FoodSurveyView : View() {
    override val root = gridpane {
        addClass(Styles.background)
        row {
            label("Food Survey") {
                addClass(Styles.foodSurveyTitleText)
                gridpaneConstraints {
                    hAlignment = HPos.CENTER
                }
            }
        }
        row {
            scrollpane {
                gridpane {
                    for (i in 1..100) {
                        row {
                            label("Question $i")
                        }
                    }
                    row {
                        button("Back") {
                            addClass(Styles.backButton)
                            action {
                                this@FoodSurveyView.replaceWith(StartScreenView::class, centerOnScreen = true)
                            }
                            gridpaneConstraints {
                                marginTop = 25.0
                                columnSpan = 1
                                hAlignment = HPos.CENTER
                            }
                        }
                    }
                }
            }
        }
    }
}