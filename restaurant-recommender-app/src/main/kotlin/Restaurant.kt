class Restaurant () {
    var restaurantId = ""
    var name = ""
    var cuisine = ""
    var openTime = ""
    var closeTime = ""
    var daysOpen = ""
    var priceRating = -1
        set(price) {
            if (price in 1..5) {
                field = price
            } else {
                field = -1
            }
        }
    var rating = -1
        set(inputRating) {
            if (inputRating <= 0 || inputRating > 5) {
                field = inputRating
            } else {
                field = -1
            }
        }
    var location = ""
    var description = ""
}