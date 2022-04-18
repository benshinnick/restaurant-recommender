import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import tornadofx.*

class RecommendView : View() {
    private var restaurantNameLabel : Label by singleAssign()
    private var cuisineLabel : Label by singleAssign()
    private var ratingLabel : Label by singleAssign()
    private var addressLabel : Label by singleAssign()
    private var hoursLabel : Label by singleAssign()
    private var descriptionLabel : Label by singleAssign()
    private var enjoyTextLabel : Label by singleAssign()
    private var newRecommendationButton : Button by singleAssign()
    private var selectButton : Button by singleAssign()
    private var neverButton : Button by singleAssign()
    private var backButton : Button by singleAssign()

    override val root = gridpane {
        addClass(Styles.background)
        row {
            label("Recommendations") {  addClass(Styles.recommendationsTitleText)
                gridpaneConstraints {  margin = Insets(5.0, 25.0, 5.0, 25.0); hAlignment = HPos.CENTER }
            }
        }
        row {
            gridpane {
                addClass(Styles.restaurantInfoDisplay)
                row {
                    label("") {  addClass(Styles.restaurantInfoText); restaurantNameLabel = this
                        gridpaneConstraints {  margin = Insets(5.0, 25.0, 5.0, 25.0); hAlignment = HPos.LEFT  }
                    }
                }
                row {
                    label("") {  addClass(Styles.restaurantInfoText); ratingLabel = this
                        gridpaneConstraints {  margin = Insets(5.0, 25.0, 5.0, 25.0); hAlignment = HPos.LEFT  }
                    }
                }
                row {
                    label("") {  addClass(Styles.restaurantInfoText); cuisineLabel = this
                        gridpaneConstraints {  margin = Insets(5.0, 25.0, 5.0, 25.0); hAlignment = HPos.LEFT  }
                    }
                }
                row {
                    label("") {  addClass(Styles.restaurantInfoText); addressLabel = this
                        gridpaneConstraints {  margin = Insets(5.0, 25.0, 5.0, 25.0); hAlignment = HPos.LEFT  }
                    }
                }
                row {
                    label("") {  addClass(Styles.restaurantInfoText); hoursLabel = this
                        gridpaneConstraints {  margin = Insets(5.0, 25.0, 5.0, 25.0); hAlignment = HPos.LEFT  }
                    }
                }
                row {
                    label("") {  addClass(Styles.restaurantInfoText); descriptionLabel = this
                        gridpaneConstraints {  margin = Insets(5.0, 25.0, 5.0, 25.0); hAlignment = HPos.LEFT  }
                    }
                }
            }
        }
        row {
            button("New Recommendation") { addClass(Styles.newRecommendationButton); newRecommendationButton = this
                action {
                    // Here is where we extract recommendation + restaurant info to display
                    selectButton.isVisible = true
                    neverButton.isVisible = true
                    setRestaurantInfo("Le Bateau Rouge", 4, "french", "44 Park Ave", "11:00 - 22:00 (Mo,Tu,We,Th,Fr,Sa,Su)","Fine French dining in a romantic setting. From soupe à l'oignon to coq au vin, let our chef delight you with a local take on authentic favorites.")
                }
                gridpaneConstraints {  margin = Insets(5.0, 25.0, 5.0, 25.0); hAlignment = HPos.CENTER  }
            }
        }
        row {
            hbox {
                button("Select") { addClass(Styles.selectRecommendationButton); selectButton = this
                    action {
                        enjoyTextLabel.text = "Enjoy!"
                        newRecommendationButton.isVisible = false
                        selectButton.isVisible = false
                        neverButton.isVisible = false
                        backButton.isVisible = true
                    }
                    hboxConstraints { margin = Insets(5.0); alignment = Pos.CENTER }
                }
                button("Never") { addClass(Styles.neverButton); neverButton = this
                    action {
                        println("Never Button Pressed")
                    }
                    hboxConstraints { margin = Insets(5.0); alignment = Pos.CENTER }
                }
                gridpaneConstraints {  margin = Insets(5.0, 25.0, 5.0, 70.0); hAlignment = HPos.CENTER  }
            }
        }
        row {
            label("") {  addClass(Styles.restaurantInfoText); enjoyTextLabel = this
                gridpaneConstraints {  margin = Insets(5.0, 25.0, 5.0, 25.0); hAlignment = HPos.CENTER  }
            }
        }
        row {
            button("Back To Start") { addClass(Styles.backToStartButton); backButton = this
                action {
                    replaceWith<StartScreenView>(centerOnScreen = true)
                }
                gridpaneConstraints {  margin = Insets(5.0, 25.0, 5.0, 25.0); hAlignment = HPos.CENTER  }
            }
        }
        run {
            selectButton.isVisible = false
            neverButton.isVisible = false
            backButton.isVisible = false
        }
    }

    // Ideally we change this function to accept just a restaurant parameter
    private fun setRestaurantInfo(name: String, rating: Int, cuisine: String, address: String, hoursInfo: String, description: String) {
        restaurantNameLabel.text = "Name: $name"
        ratingLabel.text = "Rating: ${getRatingStarsText(rating)}"
        cuisineLabel.text = "Cuisine: $cuisine"
        addressLabel.text = "Address:  $address,\n\t\tPensacola, FL 32514"
        hoursLabel.text = "Hours:\n$hoursInfo"
        descriptionLabel.text = "Description:\n$description"
    }

    private fun getRatingStarsText(rating: Int): String {
        var ratingText = ""
        for (i in 1..5) {
            if(i <= rating) ratingText += "★ "
            if(i > rating) ratingText += "☆ "
        }
        return ratingText
    }

    override fun onUndock() {
        restaurantNameLabel.text = ""
        cuisineLabel.text = ""
        ratingLabel.text = ""
        addressLabel.text = ""
        hoursLabel.text = ""
        descriptionLabel.text = ""
        enjoyTextLabel.text = ""
        newRecommendationButton.isVisible = true
        selectButton.isVisible = false
        neverButton.isVisible = false
        backButton.isVisible = false
    }
}