class RunApp {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            RestaurantData().readFile()
            Application().main(args)
        }
    }
}