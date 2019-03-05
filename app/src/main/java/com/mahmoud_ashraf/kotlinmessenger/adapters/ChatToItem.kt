package com.mahmoud_ashraf.kotlinmessenger.adapters

import com.mahmoud_ashraf.kotlinmessenger.R
import com.mahmoud_ashraf.kotlinmessenger.models.User
import com.squareup.picasso.Picasso
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.chat_to_row.view.*

/**
 * Created by mahmoud_ashraf on 04/03/2019.
 */
class ChatToItem (val text : String, val user: User) : Item<ViewHolder>() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.textview_to_row.text = text

        // load our image into the star
        val uri = user.profileImageUrl
        val targetImageView = viewHolder.itemView.imageview_chat_to_row
        Picasso.get().load(uri).into(targetImageView)
    }

    override fun getLayout(): Int {
        return R.layout.chat_to_row
    }
}