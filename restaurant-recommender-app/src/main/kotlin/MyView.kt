import tornadofx.*
import javafx.scene.paint.Color
import javafx.scene.text.*

class MyView: View() {
    override val root = vbox {
        label("Food Recommender") {
            style {
                fontWeight = FontWeight.EXTRA_BOLD
                fontFamily = "Arial"
            }
        }
        button("Press Me") {
            style {
                fontWeight = FontWeight.EXTRA_BOLD
                fontFamily = "Arial"
                borderColor += box(
                    top = Color.RED,
                    right = Color.DARKGREEN,
                    left = Color.ORANGE,
                    bottom = Color.PURPLE
                )
            }

            setOnAction { println("You pressed the button") }
        }
    }
}