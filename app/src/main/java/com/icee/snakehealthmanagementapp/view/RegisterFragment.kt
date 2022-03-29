package com.icee.snakehealthmanagementapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.icee.snakehealthmanagementapp.R
import com.icee.snakehealthmanagementapp.databinding.FragmentRegisterBinding
import com.icee.snakehealthmanagementapp.viewmodel.RegisterData

class RegisterFragment: Fragment(){
    private lateinit var binding: FragmentRegisterBinding
    private val viewmodel by viewModels<RegisterData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewmodel

        viewmodel.clickedState.observe(viewLifecycleOwner) {
            when(it) {
                "MAIN" -> (activity as MainActivity).navMain()
                "LOGIN" -> findNavController().navigate(R.id.register_to_login)
            }
        }

        return binding.root
    }
}
