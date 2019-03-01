package com.mahmoud_ashraf.kotlinmessenger

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // you can access view in kotlin by its id only
        val email = username_edittext_register.text.toString()
        val password = password_edittext_register.text.toString()

        register_button_register.setOnClickListener {
            Log.d("MainActivity", "Email is: " + email)
            Log.d("MainActivity", "Password: $password")
        }

        already_have_account_text_view.setOnClickListener {
            Log.d("MainActivity", "Try to show login activity")

            // launch the login activity somehow
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


    }
}
