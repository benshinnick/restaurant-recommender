import java.io.File
import java.util.Vector

object RestaurantData {
    var filename = "RestaurantData.csv"
    var restaurants =  Vector<Restaurant>()

    fun readFile() {
        val file = File(filename).readLines()

        for (line in file) {
            val tokens = line.split(",")
            val newRestaurant = Restaurant()

            var count = 0
            newRestaurant.name = tokens[count]
            newRestaurant.restaurantId = tokens[++count]
            newRestaurant.cuisine = tokens[++count]
            newRestaurant.openTime = tokens[++count]
            newRestaurant.closeTime = tokens[++count]

            newRestaurant.daysOpen = tokens[++count] + " "

            count++
            while(count < tokens.size) {
                if (tokens[count].contains("\"")) {
                    newRestaurant.daysOpen += tokens[count]
                    break
                }
                newRestaurant.daysOpen += tokens[count] + " "
                count++
            }

            newRestaurant.priceRating = tokens[++count].toInt()
            newRestaurant.rating = tokens[++count].toInt()
            newRestaurant.location = tokens[++count]


            if (newRestaurant.location.contains("\"")) {
                    count++
                    while(count < tokens.size) {
                        if (tokens[count].contains("\"")) {
                            newRestaurant.description += tokens[count]
                            break
                        }
                        newRestaurant.description += tokens[count]
                        count++
                    }
            }

                newRestaurant.description = tokens[++count]

                count++
                while(count < tokens.size) {
                        if (tokens[count].contains("\"")) {
                            newRestaurant.description += tokens[count]
                            break
                        }
                        newRestaurant.description += tokens[count]
                        count++
                    }

                    restaurants.add(newRestaurant)
            }

    }
}