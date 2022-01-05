package com.feizai.compose

import android.content.Context
import android.graphics.Color
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * Author: chenhao
 * Date: 2021/12/27-0027 上午 10:18:13
 * Describe:
 */
class MyAdapter(context: Context?,
                       data: MutableList<String>?
) : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item, data) {

    var mContext: Context? = context
    var mData: List<String>? = data

    override fun convert(holder: BaseViewHolder, item: String) {
//        TODO("Not yet implemented")
        holder.setText(R.id.title, item)
        holder.setTextColor(R.id.title, Color.BLUE)
    }
}