import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.scene.control.Label
import javafx.scene.control.TextField
import tornadofx.*

class RecommendView : View() {
    private var restuarantNameLabel : Label by singleAssign()
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
            label("") {  addClass(Styles.restaurantInfoText); restuarantNameLabel = this
                gridpaneConstraints {  margin = Insets(5.0, 25.0, 5.0, 25.0); hAlignment = HPos.LEFT  }
            }
        }
        row {
            label("") {  addClass(Styles.restaurantInfoText); cuisineLabel = this
                gridpaneConstraints {  margin = Insets(5.0, 25.0, 5.0, 25.0); hAlignment = HPos.LEFT  }
            }
        }
        row {
            label("") {  addClass(Styles.restaurantInfoText); ratingLabel = this
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
                    restuarantNameLabel.text = "Name: " + "Le Bateau Rouge"
                    cuisineLabel.text = "Cuisine: " + "french"
                    ratingLabel.text = "Rating: " + "★ ★ ★ ★ ☆"
                    addressLabel.text = "Address:  " + "44 Park Ave," + "\n\t\tPensacola, FL 32514"
                    descriptionLabel.text = "Description:\n" + "Fine French dining in a romantic setting. From soupe à l'oignon to coq au vin, let our chef delight you with a local take on authentic favorites."
                }
            }
        }
    }
}