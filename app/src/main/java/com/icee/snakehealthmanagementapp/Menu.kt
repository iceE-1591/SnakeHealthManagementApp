package com.icee.snakehealthmanagementapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Menu: Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.menu, container, false)
        val profile: View = view.findViewById(R.id.profile)
        val settings: View = view.findViewById(R.id.settings)
        val feedback: View = view.findViewById(R.id.feedback)
        val help: View = view.findViewById(R.id.help)
        return view
    }
}
