package com.mahmoud_ashraf.kotlinmessenger.adapters

import com.letsbuildthatapp.kotlinmessenger.models.ChatMessage
import com.mahmoud_ashraf.kotlinmessenger.R
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.latest_message_row.view.*

/**
 * Created by mahmoud_ashraf on 05/03/2019.
 */
class LatestMessageRow(val chatMessage: ChatMessage): Item<ViewHolder>() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.message_textview_latest_message.text = chatMessage.text
    }

    override fun getLayout(): Int {
        return R.layout.latest_message_row
    }
}