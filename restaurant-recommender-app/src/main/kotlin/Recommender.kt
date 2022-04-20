
class RestData {
    val list = arrayOf(Restaurant("Bell"), Restaurant("Donahue"), Restaurant("Nunez"))
}

class Restaurant(var name: String)

class Recommender(restaurantData: RestData) {

    private val initMaxCoolDown = 7
    private val timeDecrement = 0.1
    private val parallelData = Array(restaurantData.list.size) { Data(initMaxCoolDown) }
    private val sortedIndices = Array(restaurantData.list.size) { -1 }
    private var currentIndex = 0

    private val userPrefTemp = 3

    init {
        for (i in parallelData.indices)
            parallelData[i].restaurant = restaurantData.list[i]
    }

    class Data(
        var maxCoolDown: Int,
        var coolDown: Int = 0,
        val timesPreferred: DoubleArray = doubleArrayOf(1.0, 1.0, 1.0),
        var restaurant: Restaurant? = null
    ) {
        fun decrementCoolDown() {
            if (--coolDown < 0)
                coolDown = maxCoolDown
        }
    }

    fun decrementAllCoolDowns() {
        for (d in parallelData)
            d.decrementCoolDown()
    }

    fun resetCoolDown(data: Data) {
        data.coolDown = data.maxCoolDown
    }

    fun generateRecommendations(userPreferences: Array<Int>, timeOfDay: Int) {
        currentIndex = 0
        for (i in parallelData.indices) {
            var max = 0.0
            var nextIndex = 0
            for (checking in parallelData.indices) {
                if (sortedIndices.contains(checking))
                    continue
                val data = parallelData[checking]
                val heuristic = (data.maxCoolDown - data.coolDown) * userPrefTemp * data.timesPreferred[timeOfDay]
                if (heuristic >= max) {
                    max = heuristic
                    nextIndex = checking
                }
            }
            sortedIndices[i] = nextIndex
        }
    }

    fun hasNext(): Boolean {
        return currentIndex < parallelData.size
    }

    fun getNextRecommendation(): Restaurant? {
        return parallelData[sortedIndices[currentIndex++]].restaurant
    }

}