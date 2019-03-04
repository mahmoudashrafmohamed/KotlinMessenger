package com.mahmoud_ashraf.kotlinmessenger.messages

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.mahmoud_ashraf.kotlinmessenger.R
import com.mahmoud_ashraf.kotlinmessenger.adapters.UserItem
import com.mahmoud_ashraf.kotlinmessenger.models.User
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_new_message.*

class NewMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_message)

        // change the title of action bar
        supportActionBar?.title = "Select User"

        // Group adapter
       // val adapter = GroupAdapter<ViewHolder>()

        // now need to add users data in adapter for ex:
        //adapter.add(UserItem())
        //adapter.add(UserItem())
        //adapter.add(UserItem())

        // set the adapter of recycler
      //  recyclerview_newmessage.adapter = adapter

        fetchUsers()
    }
    private fun fetchUsers() {
        val ref = FirebaseDatabase.getInstance().getReference("/users")
        ref.addListenerForSingleValueEvent(object: ValueEventListener {

            override fun onDataChange(p0: DataSnapshot) {
                val adapter = GroupAdapter<ViewHolder>()

                p0.children.forEach {
                    Log.d("NewMessage", it.toString())

                    val user = it.getValue(User::class.java)
                    if (user != null) {
                        adapter.add(UserItem(user))
                    }
                }
                // add click listener on rv item in Groupe lib
                adapter.setOnItemClickListener { item, view ->
                   val intent = Intent(view.context,ChatLogActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                recyclerview_newmessage.adapter = adapter
            }

            override fun onCancelled(p0: DatabaseError) {
            }
        })
    }
}


