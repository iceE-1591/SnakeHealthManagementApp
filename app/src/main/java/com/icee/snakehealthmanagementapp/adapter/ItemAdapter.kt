package com.icee.snakehealthmanagementapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.icee.snakehealthmanagementapp.R
import com.icee.snakehealthmanagementapp.RowData
import com.icee.snakehealthmanagementapp.ViewHolderItem

class ItemAdapter(context: Context, itemList:List<RowData>): ArrayAdapter<RowData>(context,0,itemList){
    private val layoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val holder: ViewHolderItem
        val view: View // convertView
        if(convertView == null) { // 前回のViewが存在しない時
            view = layoutInflater.inflate(R.layout.row, parent,false)
            val imageView = view.findViewById(R.id.petIcon) as ImageView
            val textView = view.findViewById(R.id.petName) as TextView
            holder = ViewHolderItem(imageView, textView)
            view.tag = holder
        } else {
            holder = convertView.tag as ViewHolderItem
            view = convertView
        }
        // 処理
        val rowData: RowData? = getItem(position)
        holder.icon.setImageResource(R.drawable.profile_icon)
        holder.name.text = rowData?.name
        return view
    }
}
