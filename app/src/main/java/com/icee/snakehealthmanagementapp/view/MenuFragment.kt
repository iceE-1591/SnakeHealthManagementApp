package com.icee.snakehealthmanagementapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.icee.snakehealthmanagementapp.R
import com.icee.snakehealthmanagementapp.databinding.MenuBinding
import com.icee.snakehealthmanagementapp.viewmodel.MenuData

class Menu: Fragment(){
    private lateinit var binding: MenuBinding
    private val viewmodel by viewModels<MenuData>()

    //profile,settings,feedback,helpが入る
    private val views = mutableListOf<View>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.menu, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewmodel

        val profile = binding.profile
        val settings = binding.settings
        val feedback = binding.feedback
        val help = binding.help
        views.addAll(listOf(profile, settings, feedback, help))

        binding.profile.setOnClickListener {
            changeBackgroundColor(profile)
        }

        binding.settings.setOnClickListener {
            changeBackgroundColor(settings)
        }

        binding.feedback.setOnClickListener {
            changeBackgroundColor(feedback)
        }

        binding.help.setOnClickListener {
            changeBackgroundColor(help)
        }
        return binding.root
    }

    // クリックしたViewの背景色をメイン色に変更
    private fun changeBackgroundColor(view: View) {
        val viewsCopy = views.toMutableList()
        viewsCopy.remove(view)
        viewsCopy.forEach{ v ->
            v.setBackgroundResource(R.color.MenuColor)
        }
        view.setBackgroundResource(R.color.MainColor)
    }
}
