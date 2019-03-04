package com.mahmoud_ashraf.kotlinmessenger.messages

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mahmoud_ashraf.kotlinmessenger.R
import com.mahmoud_ashraf.kotlinmessenger.adapters.ChatFromItem
import com.mahmoud_ashraf.kotlinmessenger.adapters.ChatToItem
import com.mahmoud_ashraf.kotlinmessenger.models.User
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_chat_log.*

class ChatLogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_log)

       // val username = intent.getStringExtra(NewMessageActivity.USER_KEY)
        val user = intent.getParcelableExtra<User>(NewMessageActivity.USER_KEY)
        // change the title of action bar
        supportActionBar?.title = user.username


        /*
        run the test on chat log recycler
         */
        val adapter = GroupAdapter<ViewHolder>()

        adapter.add(ChatFromItem())
        adapter.add(ChatToItem())
        adapter.add(ChatFromItem())
        adapter.add(ChatToItem())
        adapter.add(ChatFromItem())
        adapter.add(ChatToItem())
        adapter.add(ChatFromItem())
        adapter.add(ChatToItem())

        recyclerview_chat_log.adapter = adapter
    }
}
