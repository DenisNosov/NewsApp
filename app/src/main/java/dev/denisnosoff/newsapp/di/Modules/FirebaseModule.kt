package dev.denisnosoff.newsapp.di.Modules

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Module
class FirebaseModule {

    @Provides
    fun provideFirebaseAuth() : FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    fun provideFirebaseDatabase() : FirebaseDatabase = FirebaseDatabase.getInstance()
}