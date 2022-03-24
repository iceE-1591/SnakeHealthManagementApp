package com.icee.snakehealthmanagementapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.ListFragment
import com.icee.snakehealthmanagementapp.adapter.ItemAdapter
import com.icee.snakehealthmanagementapp.entity.RowData

class ListFragment : ListFragment() {
    var data = listOf(RowData("path", "test1"), RowData("path", "test2"))
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val adapter = ItemAdapter(this.requireContext(), data)
        listAdapter = adapter
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        listView.onItemClickListener =
            AdapterView.OnItemClickListener { av, v, pos, id ->
                System.out.println(pos)
            }
    }
}
