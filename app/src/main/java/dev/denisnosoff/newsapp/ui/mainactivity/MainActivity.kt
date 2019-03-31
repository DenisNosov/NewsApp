package dev.denisnosoff.newsapp.ui.mainactivity

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dev.denisnosoff.newsapp.R
import dev.denisnosoff.newsapp.ui.loginactivity.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    companion object {
        fun start(activity: Activity) {
            activity.startActivity(activity.intentFor<MainActivity>().clearTask())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()

        initViews()
    }

    private fun initViews() {
        btnLogOut.setOnClickListener {
            viewModel.logOut()
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]

        viewModel.signOutLiveData.observe(this, Observer {
            LoginActivity.start(this)
        })
    }
}
