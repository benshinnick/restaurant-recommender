import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.scene.control.TextField
import tornadofx.*

class FoodSurveyView : View() {
    var fNameField : TextField by singleAssign()
    var lNameField : TextField by singleAssign()
    private var cuisineList = listOf(
        "american",
        "french",
        "chinese",
        "mexican",
        "japanese",
        "thai",
        "indian",
        "german",
        "african",
        "czech/slovak",
        "vegetarian",
        "pizza",
        "barbecue",
        "cafe"
    )
    var cuisinePreferences = IntArray(cuisineList.size)


    override val root = gridpane {
        addClass(Styles.background)

        row {
            label("Food Survey") {
                addClass(Styles.foodSurveyTitleText)
                gridpaneConstraints {  margin = Insets(25.0); hAlignment = HPos.CENTER  }
            }
        }
        row {
            scrollpane {
                addClass(Styles.foodSurveyScrollPane)
                gridpane {
                    row {
                        form {
                            fieldset("Personal Info") {
                                field("First Name") {
                                    textfield() { fNameField = this }
                                }
                                field("Last Name") {
                                    textfield() { lNameField = this }
                                }
                            }
                            fieldset("Food Preferences (5 = love)") {
                                for (i in cuisineList.indices) {
                                    field(cuisineList[i]) {
                                        listmenu(orientation = Orientation.HORIZONTAL) {
                                            for(j in 0 .. 5) {
                                                item(text = j.toString()) { whenSelected {cuisinePreferences[i] = j} }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    row {
                        hbox {
                            button("Back") {
                                addClass(Styles.backButton)
                                action { backButtonOnClick() }
                                hboxConstraints {  margin = Insets(15.0)  }
                            }
                            button("Submit") {
                                addClass(Styles.submitButton)
                                action { submitButtonOnClick() }
                                hboxConstraints {  margin = Insets(15.0)  }
                            }
                            gridpaneConstraints {  hAlignment = HPos.CENTER; isFocusTraversable = false }
                        }
                    }
                }
                gridpaneConstraints { marginLeft = 25.0; marginBottom = 25.0 }
            }
        }
    }

    private fun backButtonOnClick() {
        replaceWith<StartScreenView>(centerOnScreen = true)
    }

    private fun submitButtonOnClick() {
        // Printing out results
        println("\n${fNameField.textProperty().value} ${lNameField.textProperty().value} Submitted")
        println("\nResults:")
        for (i in cuisineList.indices) {
            println("  " + cuisinePreferences[i].toString() + " - " + cuisineList[i])
        }

        UserManager.addUser(fNameField.text, lNameField.text, cuisineList, cuisinePreferences)
        replaceWith<RecommendView>(centerOnScreen = true)
    }
}