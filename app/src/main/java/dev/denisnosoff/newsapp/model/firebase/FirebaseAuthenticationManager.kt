package dev.denisnosoff.newsapp.model.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import javax.inject.Inject

class FirebaseAuthenticationManager(
    private val authentication: FirebaseAuth
) {

    fun register(email: String, password: String, username: String, onResult: (Boolean) -> Unit) {
        authentication.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isComplete && it.isSuccessful) {
                    authentication.currentUser?.updateProfile(UserProfileChangeRequest
                        .Builder()
                        .setDisplayName(username)
                        .build())
                    onResult(true)
                } else {
                    onResult(false)
                }
            }
    }

    fun login(email: String, password: String, onResult: (Boolean) -> Unit) {
        authentication.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                onResult(it.isComplete && it.isSuccessful)
            }
    }

    fun getUserId() : String = authentication.currentUser?.uid ?: ""

    fun logOut() {
        authentication.signOut()
    }
}