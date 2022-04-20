class Restaurant () {
    var restaurantId = ""
    var name = ""
    var cuisine = ""
    var openTime = ""
    var closeTime = ""
    var daysOpen = ""
    var location = ""
    var description = ""
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
                field = -1
            } else {
                field = inputRating
            }
        }

    fun getHoursInfoString(): String {
        return "${openTime.subSequence(0,5)} - ${closeTime.subSequence(0,5)} (${daysOpen.subSequence(1, daysOpen.length - 1)})"
    }
}