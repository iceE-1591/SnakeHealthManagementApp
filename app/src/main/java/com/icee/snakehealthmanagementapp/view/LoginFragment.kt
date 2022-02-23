package com.icee.snakehealthmanagementapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.icee.snakehealthmanagementapp.R
import com.icee.snakehealthmanagementapp.databinding.FragmentLoginBinding
import com.icee.snakehealthmanagementapp.viewmodel.LoginData

class LoginFragment: Fragment(){
    private lateinit var binding: FragmentLoginBinding
    private val viewmodel by viewModels<LoginData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewmodel
        return binding.root
    }
}