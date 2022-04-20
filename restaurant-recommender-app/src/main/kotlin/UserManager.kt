import java.util.Vector

class UserManager {
    var users = Vector<User>()

    fun addUser(firstName: String, lastName: String, cuisineList: List<String>, cuisinePreferences: IntArray) {
        val newUser = User()
        newUser.firstName = firstName
        newUser.lastName = lastName

        for (i in 1 until cuisineList.size) {
            newUser.addPreference(cuisineList[i], cuisinePreferences[i])
        }

        users.add(newUser)
    }

    fun findUser(firstName : String): User? {
        for (user in users) {
            if (user.firstName == firstName) {
                return user
            }
        }

        return null
    }

    fun findUserPreference(firstName: String, cuisine : String): Int? {
        for (user in users) {
            if (user.firstName == firstName) {
                return user.findPreference(cuisine)
            }
        }

        return -1
    }
}