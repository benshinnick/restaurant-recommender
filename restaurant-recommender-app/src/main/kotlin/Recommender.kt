
class Recommender(restaurantData: RestaurantData) {

    private val initMaxCoolDown = 7
    private val maxCoolDownDecrement = 1
    private val maxCoolDownIncrement = 1
    private val timeDecrement = 0.1
    private val timeIncrement = 1.0
    private val parallelData = Array(restaurantData.restaurants.size) { Data(initMaxCoolDown) }
    private val sortedIndices = Array(parallelData.size) { -1 }
    private var currentIndex = parallelData.size
    private var currentTimeOfDay = -1

    private val userPrefTemp = 3

    init {
        for (i in parallelData.indices)
            parallelData[i].restaurant = restaurantData.restaurants[i]
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

    fun generateRecommendations(user: User, timeOfDay: Int) {
        currentIndex = 0
        currentTimeOfDay = timeOfDay
        for (i in parallelData.indices) {
            var max = 0.0
            var nextIndex = 0
            for (checking in parallelData.indices) {
                if (sortedIndices.contains(checking))
                    continue
                val data = parallelData[checking]
                val heuristic = (data.maxCoolDown - data.coolDown) * user.findPreference(data.restaurant!!.cuisine)!! * data.timesPreferred[timeOfDay]
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

    fun passCurrent() {
        val data = parallelData[sortedIndices[currentIndex]]
        data.timesPreferred[currentTimeOfDay] -= timeDecrement
        if (data.coolDown == 0)
            data.maxCoolDown += maxCoolDownIncrement
    }

    fun acceptCurrent() {
        val data = parallelData[sortedIndices[currentIndex]]
        data.timesPreferred[currentTimeOfDay] += timeIncrement
        if (data.coolDown > 0)
            if (data.maxCoolDown > 0)
            data.maxCoolDown -= maxCoolDownDecrement
    }

    fun rejectCurrent() {
        val data = parallelData[sortedIndices[currentIndex]]
        data.timesPreferred[0] = 0.0
        data.timesPreferred[1] = 0.0
        data.timesPreferred[2] = 0.0
    }
}