package com.mahmoud_ashraf.kotlinmessenger.messages

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.letsbuildthatapp.kotlinmessenger.models.ChatMessage
import com.mahmoud_ashraf.kotlinmessenger.R
import com.mahmoud_ashraf.kotlinmessenger.adapters.ChatFromItem
import com.mahmoud_ashraf.kotlinmessenger.adapters.ChatToItem
import com.mahmoud_ashraf.kotlinmessenger.models.User
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_chat_log.*

class ChatLogActivity : AppCompatActivity() {

    companion object {
        val TAG = "ChatLog"
    }

    val adapter = GroupAdapter<ViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_log)

        recyclerview_chat_log.adapter = adapter
       // val username = intent.getStringExtra(NewMessageActivity.USER_KEY)
        val user = intent.getParcelableExtra<User>(NewMessageActivity.USER_KEY)
        // change the title of action bar
        supportActionBar?.title = user.username


        //setupDummyData()
        listenForMessages()

        send_button_chat_log.setOnClickListener {
            Log.d(TAG, "Attempt to send message....")
            performSendMessage()
        }
    }

    /*
    coming messages
     */
    private fun listenForMessages() {
        val ref = FirebaseDatabase.getInstance().getReference("/messages")

        /*
        add listener to update adapter if any change in firebase db happened....
         */
        ref.addChildEventListener(object: ChildEventListener {

            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                val chatMessage = p0.getValue(ChatMessage::class.java)

                if (chatMessage != null) {
                    Log.d(TAG, chatMessage.text)


                    if (chatMessage.fromId == FirebaseAuth.getInstance().uid) {
                        adapter.add(ChatToItem(chatMessage.text))
                    } else {
                        adapter.add(ChatFromItem(chatMessage.text))
                    }
                }

            }

            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {

            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {

            }

            override fun onChildRemoved(p0: DataSnapshot) {

            }

        })

    }

    private fun performSendMessage() {
        // how do we actually send a message to firebase...
        val text = edittext_chat_log.text.toString()

        val fromId = FirebaseAuth.getInstance().uid
        val user = intent.getParcelableExtra<User>(NewMessageActivity.USER_KEY)
        val toId = user.uid

        if (fromId == null) return

        // push is automaticaaly generate an key to save our object (value) in it
        val reference = FirebaseDatabase.getInstance().getReference("/messages").push()

        val chatMessage = ChatMessage(reference.key!!, text, fromId, toId, System.currentTimeMillis() / 1000)
        reference.setValue(chatMessage)
            .addOnSuccessListener {
                Log.d(TAG, "Saved our chat message: ${reference.key}")
            }
    }
    /*
       run the test on chat log recycler
        */
    private fun setupDummyData() {
        val adapter = GroupAdapter<ViewHolder>()

        adapter.add(ChatFromItem("FROM MESSSSSSSSAAGE"))
        adapter.add(ChatToItem("TO MESSAGE\nTOMESSAGE"))
        adapter.add(ChatFromItem("FROM MESSSSSSSSAAGE"))
        adapter.add(ChatToItem("TO MESSAGE\nTOMESSAGE"))
        adapter.add(ChatFromItem("FROM MESSSSSSSSAAGE"))
        adapter.add(ChatToItem("TO MESSAGE\nTOMESSAGE"))

        recyclerview_chat_log.adapter = adapter
    }
}
