package com.mahmoud_ashraf.kotlinmessenger.adapters

import com.mahmoud_ashraf.kotlinmessenger.R
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.chat_to_row.view.*

/**
 * Created by mahmoud_ashraf on 04/03/2019.
 */
class ChatToItem (val text : String) : Item<ViewHolder>() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.textview_to_row.text = text
    }

    override fun getLayout(): Int {
        return R.layout.chat_to_row
    }
}