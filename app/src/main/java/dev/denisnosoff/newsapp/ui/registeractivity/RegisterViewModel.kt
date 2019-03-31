package dev.denisnosoff.newsapp.ui.registeractivity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dev.denisnosoff.newsapp.App
import dev.denisnosoff.newsapp.model.SingleLiveEvent
import dev.denisnosoff.newsapp.model.firebase.FirebaseAuthenticationManager
import dev.denisnosoff.newsapp.model.firebase.FirebaseDatabaseManager
import javax.inject.Inject

class RegisterViewModel(app: Application) : AndroidViewModel(app) {

    @Inject
    lateinit var authenticationManager: FirebaseAuthenticationManager

    @Inject
    lateinit var databaseManager: FirebaseDatabaseManager

    val onSuccessLiveData = SingleLiveEvent<Unit>()

    val onErrorLiveData = SingleLiveEvent<Unit>()

    init {
        getApplication<App>().component.inject(this)
    }

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