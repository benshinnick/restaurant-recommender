import java.util.*

class User {
    var firstName = ""
    var lastName = ""
    var cuisinePreferences = HashMap<String, Int>()

    fun addPreference(cuisine : String, rating : Int) {
        if (rating in 0..5) {
            cuisinePreferences.put(cuisine, rating)
        }
    }

    fun findPreference(cuisine : String): Int? {
        return cuisinePreferences[cuisine]
    }
}