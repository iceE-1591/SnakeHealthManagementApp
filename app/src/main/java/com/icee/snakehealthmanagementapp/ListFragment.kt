package com.icee.snakehealthmanagementapp

import androidx.fragment.app.ListFragment
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View

class ListFragment : ListFragment() {
    var data = listOf<String>("test1","test2")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val adapter = ItemAdapter(this.requireContext(), data)
        listAdapter = adapter
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
