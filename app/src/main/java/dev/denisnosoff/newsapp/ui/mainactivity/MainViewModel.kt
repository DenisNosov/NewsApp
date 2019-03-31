package dev.denisnosoff.newsapp.ui.mainactivity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import dev.denisnosoff.newsapp.App
import dev.denisnosoff.newsapp.model.SingleLiveEvent
import dev.denisnosoff.newsapp.model.firebase.FirebaseAuthenticationManager
import dev.denisnosoff.newsapp.model.firebase.FirebaseDatabaseManager
import javax.inject.Inject

class MainViewModel(app: Application) : AndroidViewModel(app) {

    val signOutLiveData = SingleLiveEvent<Unit>()

    @Inject
    lateinit var authenticationManager: FirebaseAuthenticationManager

    @Inject
    lateinit var databaseManager: FirebaseDatabaseManager

    init {
        getApplication<App>().component.inject(this)
    }

    fun logOut() {
        authenticationManager.logOut()
        signOutLiveData.call()
    }
}