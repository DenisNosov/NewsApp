package dev.denisnosoff.newsapp.ui.loginactivity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import dev.denisnosoff.newsapp.App
import dev.denisnosoff.newsapp.model.SingleLiveEvent
import dev.denisnosoff.newsapp.model.firebase.FirebaseAuthenticationManager
import dev.denisnosoff.newsapp.model.firebase.FirebaseDatabaseManager
import dev.denisnosoff.newsapp.ui.mainactivity.MainActivity
import javax.inject.Inject

class LoginViewModel(app: Application) : AndroidViewModel(app) {

    val goToMainActivityLiveData = SingleLiveEvent<Unit>()
    val onErrorLiveData = SingleLiveEvent<Unit>()

    @Inject
    lateinit var authenticationManager: FirebaseAuthenticationManager

    @Inject
    lateinit var databaseManager: FirebaseDatabaseManager

    init {
        getApplication<App>().component.inject(this)
    }

    fun checkUser() {
        if (authenticationManager.getUserId() != "") {
            goToMainActivityLiveData.call()
        }
    }

    fun login(email: String, password: String) {
        authenticationManager.login(email, password) {
            if (it) {
                goToMainActivityLiveData.call()
            } else {
                onErrorLiveData.call()
            }
        }
    }
}