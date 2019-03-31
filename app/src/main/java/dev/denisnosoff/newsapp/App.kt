package dev.denisnosoff.newsapp

import android.app.Application
import dev.denisnosoff.newsapp.di.Component
import dev.denisnosoff.newsapp.di.DaggerComponent
import dev.denisnosoff.newsapp.di.modules.FirebaseModule
import dev.denisnosoff.newsapp.di.modules.InteractionModule

class App : Application() {

    lateinit var component: Component

    override fun onCreate() {
        super.onCreate()
        component = DaggerComponent.builder()
            .firebaseModule(FirebaseModule())
            .interactionModule(InteractionModule())
            .build()
    }

}