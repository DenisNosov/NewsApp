package dev.denisnosoff.newsapp.di.modules

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dev.denisnosoff.newsapp.model.firebase.FirebaseAuthenticationManager
import dev.denisnosoff.newsapp.model.firebase.FirebaseDatabaseManager
import javax.inject.Singleton

@Module
class InteractionModule {

    @Singleton
    @Provides
    fun authentication(authentication: FirebaseAuth) : FirebaseAuthenticationManager =
        FirebaseAuthenticationManager(authentication)

    @Singleton
    @Provides
    fun database(database: FirebaseDatabase) : FirebaseDatabaseManager =
        FirebaseDatabaseManager(database)

}