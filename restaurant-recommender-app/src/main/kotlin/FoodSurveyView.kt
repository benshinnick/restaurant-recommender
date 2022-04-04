import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.scene.control.RadioMenuItem
import javafx.scene.control.TextField
import tornadofx.*
import tornadofx.Stylesheet.Companion.contextMenu

class FoodSurveyView : View() {
    var fNameField : TextField by singleAssign()
    var lNameField : TextField by singleAssign()

    override val root = gridpane {
        addClass(Styles.background)
        row {
            label("Food Survey") {
                addClass(Styles.foodSurveyTitleText)
                gridpaneConstraints {
                    margin = Insets(25.0)
                    hAlignment = HPos.CENTER
                }
            }
        }
        row {
            scrollpane {
                addClass(Styles.foodSurveyScrollPane)
                gridpane {
                    row {
                        form {
                            fieldset("Personal Info (Just For Testing)") {
                                field("First Name") {
                                    textfield() {
                                        fNameField = this
                                    }
                                }
                                field("Last Name") {
                                    textfield() {
                                        lNameField = this
                                    }
                                }
                                field("Birthday") {
                                    datepicker()
                                }
                            }
                            fieldset("Food Preferences (5 = love)") {
                                field("French Cuisine") {
                                    listmenu(orientation = Orientation.HORIZONTAL) {
                                        item(text = "0")
                                        item(text = "1")
                                        item(text = "2")
                                        item(text = "3")
                                        item(text = "4")
                                        item(text = "5")
                                    }
                                }
                                field("Chinese Cuisine") {
                                    listmenu(orientation = Orientation.HORIZONTAL) {
                                        item(text = "0")
                                        item(text = "1")
                                        item(text = "2")
                                        item(text = "3")
                                        item(text = "4")
                                        item(text = "5")
                                    }
                                }
                                field("Chinese Cuisine") {
                                    listmenu(orientation = Orientation.HORIZONTAL) {
                                        item(text = "0")
                                        item(text = "1")
                                        item(text = "2")
                                        item(text = "3")
                                        item(text = "4")
                                        item(text = "5")
                                    }
                                }
                                field("Indian Cuisine") {
                                    listmenu(orientation = Orientation.HORIZONTAL) {
                                        item(text = "0")
                                        item(text = "1")
                                        item(text = "2")
                                        item(text = "3")
                                        item(text = "4")
                                        item(text = "5")
                                    }
                                }
                                field("Italian Cuisine") {
                                    listmenu(orientation = Orientation.HORIZONTAL) {
                                        item(text = "0")
                                        item(text = "1")
                                        item(text = "2")
                                        item(text = "3")
                                        item(text = "4")
                                        item(text = "5")
                                    }
                                }
                                field("Greek Cuisine") {
                                    listmenu(orientation = Orientation.HORIZONTAL) {
                                        item(text = "0")
                                        item(text = "1")
                                        item(text = "2")
                                        item(text = "3")
                                        item(text = "4")
                                        item(text = "5")
                                    }
                                }
                                field("Spanish Cuisine") {
                                    listmenu(orientation = Orientation.HORIZONTAL) {
                                        item(text = "0")
                                        item(text = "1")
                                        item(text = "2")
                                        item(text = "3")
                                        item(text = "4")
                                        item(text = "5")
                                    }
                                }
                            }
                        }
                    }
                    row {
                        hbox {
                            button("Back") {
                                addClass(Styles.backButton)
                                action {
                                    replaceWith<StartScreenView>(centerOnScreen = true)
                                }
                                hboxConstraints {
                                    margin = Insets(15.0)
                                }
                            }
                            button("Submit") {
                                addClass(Styles.submitButton)
                                action {
                                    println("${fNameField.textProperty().value} ${lNameField.textProperty().value} Submitted")
                                }
                                hboxConstraints {
                                    margin = Insets(15.0)
                                }
                            }
                            gridpaneConstraints {
                                hAlignment = HPos.CENTER
                                isFocusTraversable = false
                            }
                        }
                    }
                }
                gridpaneConstraints {
                    marginLeft = 25.0
                    marginBottom = 25.0
                }
            }
        }
    }
}