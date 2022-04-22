import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import tornadofx.*
import java.util.*

class RecommendView : View() {
    //private lateinit var recommender: Recommender
    private lateinit var recommender: Recommender

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
                action { newRecommendationButtonOnClick() }
                gridpaneConstraints {  margin = Insets(5.0, 25.0, 5.0, 25.0); hAlignment = HPos.CENTER  }
            }
        }
        row {
            hbox {
                button("Select") { addClass(Styles.selectRecommendationButton); selectButton = this
                    action { selectButtonOnClick() }
                    hboxConstraints { margin = Insets(5.0); alignment = Pos.CENTER }
                }
                button("Never") { addClass(Styles.neverButton); neverButton = this
                    action { neverButtonOnClick() }
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
                action { backToStartButtonOnClick() }
                gridpaneConstraints {  margin = Insets(5.0, 25.0, 5.0, 25.0); hAlignment = HPos.CENTER  }
            }
        }
    }

    // Initialize function
    override fun onDock() {
        setAllButtonsToInvisible()
        recommender = Recommender
        println("tesit")
        recommender.generateRecommendations(UserManager.getLatestUser(), getTimeOfDayInt())
        newRecommendationButton.isVisible = true
    }

    override fun onUndock() {
        clearAllInfoText()
        setAllButtonsToInvisible()
    }

    private fun newRecommendationButtonOnClick() {
        setAllButtonsToVisible()
        backButton.isVisible = false
        recommender.passCurrent()
        setNextRecommendation()
    }

    private fun selectButtonOnClick() {
        setAllButtonsToInvisible()
        recommender.acceptCurrent()
        backButton.isVisible = true
        enjoyTextLabel.text = "Enjoy!"
    }

    private fun neverButtonOnClick() {
        recommender.rejectCurrent()
        setNextRecommendation()
    }

    private fun backToStartButtonOnClick() {
        replaceWith<StartScreenView>(centerOnScreen = true)
    }

    private fun setNextRecommendation() {
        if(recommender.hasNext())
            recommender.getNextRecommendation()?.let { setRestaurantInfo(it) }
        else {
            setAllButtonsToInvisible()
            recommender.acceptCurrent()
            backButton.isVisible = true
            enjoyTextLabel.text = "Out of Recommendations!"
        }
    }

    private fun getTimeOfDayInt(): Int {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        if(hour < 10) return 0
        if(hour < 16) return 1
        else return 2
    }

    private fun setRestaurantInfo(restaurant: Restaurant) {
        restaurantNameLabel.text = "Name: ${restaurant.name}"
        ratingLabel.text = "Rating: ${getRatingStarsText(restaurant.rating)}"
        cuisineLabel.text = "Cuisine: ${restaurant.cuisine}"
        addressLabel.text = "Address:  ${restaurant.location},\n\t\tPensacola, FL 32514"
        hoursLabel.text = "Hours:\n${restaurant.getHoursInfoString()}"
        descriptionLabel.text = "Description:\n${restaurant.description}"
    }

    private fun getRatingStarsText(rating: Int): String {
        var ratingText = ""
        for (i in 1..5) {
            if(i <= rating) ratingText += "★ "
            if(i > rating) ratingText += "☆ "
        }
        return ratingText
    }

    private fun setAllButtonsToVisible() {
        newRecommendationButton.isVisible = true
        selectButton.isVisible = true
        neverButton.isVisible = true
        backButton.isVisible = true
    }

    private fun setAllButtonsToInvisible() {
        newRecommendationButton.isVisible = false
        selectButton.isVisible = false
        neverButton.isVisible = false
        backButton.isVisible = false
    }

    private fun clearAllInfoText() {
        restaurantNameLabel.text = ""
        cuisineLabel.text = ""
        ratingLabel.text = ""
        addressLabel.text = ""
        hoursLabel.text = ""
        descriptionLabel.text = ""
        enjoyTextLabel.text = ""
    }
}