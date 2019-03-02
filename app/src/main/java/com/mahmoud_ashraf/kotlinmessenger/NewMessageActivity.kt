package com.mahmoud_ashraf.kotlinmessenger

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class NewMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_message)

        // change the title of action bar
        supportActionBar?.title = "Select User"
    }
}
