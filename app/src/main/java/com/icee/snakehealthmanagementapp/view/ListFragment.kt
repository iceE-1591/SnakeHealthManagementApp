package com.icee.snakehealthmanagementapp.view

import androidx.fragment.app.ListFragment
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import com.icee.snakehealthmanagementapp.RowData
import com.icee.snakehealthmanagementapp.adapter.ItemAdapter

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
