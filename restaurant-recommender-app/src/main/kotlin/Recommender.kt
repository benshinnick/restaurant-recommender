
object Recommender {

    private const val initMaxCoolDown = 7
    private const val maxCoolDownDecrement = 1
    private const val maxCoolDownIncrement = 1
    private const val timeDecrement = 0.1
    private const val timeIncrement = 1.0
    private val parallelData = Array(RestaurantData.restaurants.size) { Data(initMaxCoolDown) }
    private val sortedIndices = Array(parallelData.size) { -1 }
    private var currentIndex = parallelData.size
    private var currentTimeOfDay = -1
    private lateinit var currentUser: User

    init {
        for (i in parallelData.indices)
            parallelData[i].restaurant = RestaurantData.restaurants[i]
    }

    class Data(
        var maxCoolDown: Int
    ) {
        var coolDown: Int = 0
        val timesPreferred: DoubleArray = doubleArrayOf(1.0, 1.0, 1.0)
        var restaurant: Restaurant? = null

        fun decrementCoolDown() {
            if (coolDown > 0)
                coolDown--
        }

        fun resetCoolDown() {
            coolDown = maxCoolDown
        }
    }

    fun decrementAllCoolDowns() {
        for (d in parallelData)
            d.decrementCoolDown()
    }

    fun generateRecommendations(user: User, timeOfDay: Int) {
        currentIndex = -1
        currentTimeOfDay = timeOfDay
        currentUser = user
        for (i in sortedIndices.indices)
            sortedIndices[i] = -1
        println("\nSorted list:")
        for (i in parallelData.indices) {
            var max = 0.0
            var nextIndex = 0
            for (checking in parallelData.indices) {
                if (sortedIndices.contains(checking))
                    continue
                val data = parallelData[checking]
                val heuristic = (1 - data.coolDown.toDouble() / (data.maxCoolDown + 1)) * currentUser.findPreference(data.restaurant!!.cuisine)!! * data.timesPreferred[currentTimeOfDay]
                if (heuristic >= max) {
                    max = heuristic
                    nextIndex = checking
                }
            }
            println("  heuristic: $max - ${parallelData[nextIndex].restaurant?.name}")
            sortedIndices[i] = nextIndex
        }
    }

    fun hasNext(): Boolean {
        return currentIndex < parallelData.size - 1
    }

    fun getNextRecommendation(): Restaurant? {
        return parallelData[sortedIndices[++currentIndex]].restaurant
    }

    fun passCurrent() {
        if (currentIndex >= 0) {
            val data = parallelData[sortedIndices[currentIndex]]
            data.timesPreferred[currentTimeOfDay] -= timeDecrement
            if (data.coolDown == 0)
                data.maxCoolDown += maxCoolDownIncrement
        }
    }

    fun acceptCurrent() {
        var data = parallelData[sortedIndices[currentIndex]]
        data.timesPreferred[currentTimeOfDay] += timeIncrement
        if (data.coolDown > 0) {
            if (data.maxCoolDown > 0)
                data.maxCoolDown -= maxCoolDownDecrement
        }
        data.resetCoolDown()
    }

    fun rejectCurrent() {
        val data = parallelData[sortedIndices[currentIndex]]
        data.timesPreferred[0] = 0.0
        data.timesPreferred[1] = 0.0
        data.timesPreferred[2] = 0.0
    }
}