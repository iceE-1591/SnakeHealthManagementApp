package com.icee.snakehealthmanagementapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class Fragment1: Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment1, container, false)
        view.findViewById<Button>(R.id.btn).setOnClickListener {
            findNavController().navigate(R.id.first_to_second)
        }
        return view
    }
}