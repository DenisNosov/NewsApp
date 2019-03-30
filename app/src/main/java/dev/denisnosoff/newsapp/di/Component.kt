package dev.denisnosoff.newsapp.di

import dagger.Component
import dev.denisnosoff.newsapp.di.Modules.FirebaseModule
import dev.denisnosoff.newsapp.di.Modules.InteractionModule
import javax.inject.Singleton

@Component(modules = [FirebaseModule::class, InteractionModule::class])
@Singleton
interface Component {



}