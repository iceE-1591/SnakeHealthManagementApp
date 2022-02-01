package com.icee.snakehealthmanagementapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Menu: Fragment(){
    //profile,settings,feedback,helpが入る
    private val views = mutableListOf<View>()

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
        views.addAll(listOf(profile, settings, feedback, help))
        return view
    }

    fun changeBackgroundColor(view: View) {
        val viewsCopy = views.toMutableList()
        viewsCopy.remove(view)
        viewsCopy.forEach{ v ->
            v.setBackgroundResource(R.color.MenuColor)
        }
        view.setBackgroundResource(R.color.MainColor)
    }
}
