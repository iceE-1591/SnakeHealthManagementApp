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
import com.icee.snakehealthmanagementapp.constant.ClickedState
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

        viewmodel.clickedState.observe(viewLifecycleOwner) toError@ {
            when(it) {
                ClickedState.MAIN -> {
                    if (viewmodel.checkEmail()) return@toError
                    if (viewmodel.checkPassword()) return@toError
                    (activity as MainActivity).navMain()
                }
                ClickedState.REGISTER -> {
                    if (viewmodel.checkEmail()) return@toError
                    // API(アカウントがあればエラー)
                    findNavController().navigate(R.id.login_to_register)
                }
                ClickedState.VERIFY -> {
                    if (viewmodel.checkEmail()) return@toError
                    // API(アカウントがなければエラー)
                    findNavController().navigate(R.id.login_to_verify)
                }
            }
        }
        return binding.root
    }
}
