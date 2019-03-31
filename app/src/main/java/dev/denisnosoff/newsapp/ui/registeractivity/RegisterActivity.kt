package dev.denisnosoff.newsapp.ui.registeractivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dev.denisnosoff.newsapp.R
import dev.denisnosoff.newsapp.ui.mainactivity.MainActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var viewModel : RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initViewModel()
        initViews()



    }

    private fun initViews() {
        btnRegister.setOnClickListener {
            viewModel.registerNewUser(
                etRegisterEmail.text.toString(),
                etRegisterPassword.text.toString(),
                etRegisterUsername.text.toString())
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this)[RegisterViewModel::class.java]

        viewModel.onSuccessLiveData.observe(this, Observer {
            MainActivity.start(this)
        })

        viewModel.onErrorLiveData.observe(this, Observer {
            Toast.makeText(this, "Error registering new user", Toast.LENGTH_SHORT).show()
        })
    }
}
