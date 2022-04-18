import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.scene.control.Label
import tornadofx.*

class RecommendView : View() {
    private var restaurantNameLabel : Label by singleAssign()
    private var cuisineLabel : Label by singleAssign()
    private var ratingLabel : Label by singleAssign()
    private var addressLabel : Label by singleAssign()
    private var descriptionLabel : Label by singleAssign()

    override val root = gridpane {
        addClass(Styles.background)
        row {
            label("Recommendations") {  addClass(Styles.recommendationsTitleText)
                gridpaneConstraints {  margin = Insets(5.0, 25.0, 5.0, 25.0); hAlignment = HPos.CENTER }
            }
        }
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
            label("") {  addClass(Styles.restaurantInfoText); descriptionLabel = this
                gridpaneConstraints {  margin = Insets(5.0, 25.0, 5.0, 25.0); hAlignment = HPos.LEFT  }
            }
        }
        row {
            button("generate recommendation") {
                action {
                    // Here is where we extract recommendation + restaurant info to display
                    setRestaurantInfo("Le Bateau Rouge", 4, "french", "44 Park Ave","Fine French dining in a romantic setting. From soupe à l'oignon to coq au vin, let our chef delight you with a local take on authentic favorites.")
                }
            }
        }
    }

    private fun setRestaurantInfo(name: String, rating: Int, cuisine: String, address: String, description: String) {
        restaurantNameLabel.text = "Name: $name"
        ratingLabel.text = "Rating: ${getRatingStarsText(rating)}"
        cuisineLabel.text = "Cuisine: $cuisine"
        addressLabel.text = "Address:  $address,\n\t\tPensacola, FL 32514"
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
}