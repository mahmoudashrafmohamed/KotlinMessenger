package com.mahmoud_ashraf.kotlinmessenger.adapters

import com.mahmoud_ashraf.kotlinmessenger.R
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder

/**
 * Created by mahmoud_ashraf on 04/03/2019.
 */
class ChatFromItem: Item<ViewHolder>() {
    override fun bind(viewHolder: ViewHolder, position: Int) {

    }

    override fun getLayout(): Int {
        return R.layout.chat_from_row
    }
}