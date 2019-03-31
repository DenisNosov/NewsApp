package dev.denisnosoff.newsapp.model.firebase

import com.google.firebase.database.FirebaseDatabase
import dev.denisnosoff.newsapp.model.data.User
import javax.inject.Inject

class FirebaseDatabaseManager @Inject constructor(
    private val database: FirebaseDatabase
) {

    private val USER_KEY = "users"

    fun createNewUser(email: String, id: String, username: String) {
        val user = User(email, id, username)

        database.reference
            .child(USER_KEY)
            .child(id)
            .setValue(user)
    }
}