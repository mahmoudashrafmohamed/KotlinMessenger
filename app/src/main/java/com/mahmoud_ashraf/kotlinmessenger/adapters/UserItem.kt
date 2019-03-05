package com.mahmoud_ashraf.kotlinmessenger.adapters

import com.mahmoud_ashraf.kotlinmessenger.R
import com.mahmoud_ashraf.kotlinmessenger.models.User
import com.squareup.picasso.Picasso
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.user_row_new_message.view.*

/**
 * Created by mahmoud_ashraf on 03/03/2019.
 */
/**
 * class extend from Item to represent each row in recycler and take the model class obj in constructor
 */
class UserItem(val user: User): Item<ViewHolder>() {
    // in kotlin you don't need to override viewHolder (findViewById)
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.username_textview_new_message.text = user.name

        //Picasso.get().load(user.profileImageUrl).into(viewHolder.itemView.imageview_new_message)
        if (!user.profileImageUrl!!.isEmpty()) {
         Picasso.get().load(user.profileImageUrl).placeholder(R.drawable.no_image2).into(viewHolder.itemView.imageview_new_message)
        }
    }

    override fun getLayout(): Int {
        return R.layout.user_row_new_message
    }
}