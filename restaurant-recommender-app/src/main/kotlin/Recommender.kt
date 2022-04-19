
class Recommender {

    val temps = arrayOf(Temp(3), Temp(4))

    class Temp(m: Int) {
        val max = m
        val cur = 0
        val time = arrayOf(1.0, 1.0, 1.0)
    }

    fun valueCheck(r: Recommender) {
        r.temps[0].time[1] = 2.0
    }

}