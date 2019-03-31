package dev.denisnosoff.newsapp.ui.loginactivity

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dev.denisnosoff.newsapp.R
import dev.denisnosoff.newsapp.ui.mainactivity.MainActivity
import dev.denisnosoff.newsapp.ui.registeractivity.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast

class LoginActivity : AppCompatActivity() {

    companion object {
        fun start(activity: Activity) {
            activity.startActivity(activity.intentFor<LoginActivity>().clearTask())
        }
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initViewModel()

        initViews()
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this)[LoginViewModel::class.java]

        viewModel.goToMainActivityLiveData.observe(this, Observer {
            MainActivity.start(this)
        })

        viewModel.onErrorLiveData.observe(this, Observer {
            toast("Error logging in")
        })

        viewModel.checkUser()
    }

    private fun initViews() {
        tvRegister.setOnClickListener {
            RegisterActivity.start(this)
        }

        btnLogin.setOnClickListener {
            viewModel.login(
                etLoginEmail.text.toString(),
                etLoginPassword.text.toString())
        }
    }
}
