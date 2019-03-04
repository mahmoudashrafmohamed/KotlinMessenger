package com.mahmoud_ashraf.kotlinmessenger.messages

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mahmoud_ashraf.kotlinmessenger.R

class ChatLogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_log)

        // change the title of action bar
        supportActionBar?.title = "Chat Log"
    }
}
