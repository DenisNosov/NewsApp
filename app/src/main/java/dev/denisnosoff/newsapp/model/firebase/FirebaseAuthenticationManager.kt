package dev.denisnosoff.newsapp.model.firebase

import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class FirebaseAuthenticationManager @Inject constructor(
    private val authentication: FirebaseAuth
) {

}