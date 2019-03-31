package dev.denisnosoff.newsapp.di

import dagger.Component
import dev.denisnosoff.newsapp.di.modules.FirebaseModule
import dev.denisnosoff.newsapp.di.modules.InteractionModule
import dev.denisnosoff.newsapp.ui.loginactivity.LoginViewModel
import dev.denisnosoff.newsapp.ui.mainactivity.MainViewModel
import dev.denisnosoff.newsapp.ui.registeractivity.RegisterViewModel
import javax.inject.Singleton

@Component(modules = [FirebaseModule::class, InteractionModule::class])
@Singleton
interface Component {

    fun inject(loginViewModel: LoginViewModel)

    fun inject(registerViewModel: RegisterViewModel)

    fun inject(mainViewModel: MainViewModel)
}