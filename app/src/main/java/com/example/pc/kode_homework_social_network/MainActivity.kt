package com.example.pc.kode_homework_social_network

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.TextInputLayout
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val login = login.text.toString()
            val password = password.text.toString()
            if (login == "test" && password == "test") {
                intent = Intent(this, FeedActivity::class.java)
                startActivity(intent)
            } else if (login == "")
                Snackbar.make(it, "Не введен логин", Snackbar.LENGTH_LONG).show()
            else if (password == "")
                Snackbar.make(it, "Не введен пароль", Snackbar.LENGTH_LONG).show()
            else if (login == "" && password == "")
                Snackbar.make(it, "Не введены данные", Snackbar.LENGTH_LONG).show()
            else if (login != "test")
                Snackbar.make(it, "Не правильный логин", Snackbar.LENGTH_LONG).show()
            else if (password != "test")
                Snackbar.make(it, "Не правильный пароль", Snackbar.LENGTH_LONG).show()
        }
    }
}
