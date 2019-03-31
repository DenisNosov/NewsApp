package dev.denisnosoff.newsapp.ui.registeractivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.denisnosoff.newsapp.model.SingleLiveEvent
import dev.denisnosoff.newsapp.model.firebase.FirebaseAuthenticationManager
import dev.denisnosoff.newsapp.model.firebase.FirebaseDatabaseManager
import javax.inject.Inject

class RegisterViewModel @Inject constructor(
    private val authenticationManager: FirebaseAuthenticationManager,
    private val databaseManager: FirebaseDatabaseManager
) : ViewModel() {

    val onSuccessLiveData = SingleLiveEvent<Unit>()

    val onErrorLiveData = SingleLiveEvent<Unit>()

    fun registerNewUser(email: String, password: String, username: String) {
        authenticationManager.register(email, password, username) {
            if (it) {
                processSuccessResult(email, username)
            } else {
                processErrorResult()
            }
        }
    }

    private fun processErrorResult() {
        onErrorLiveData.call()
    }

    private fun processSuccessResult(email: String, username: String) {
        val id = authenticationManager.getUserId()
        databaseManager.createNewUser(email, id, username)

        onSuccessLiveData.call()
    }
}