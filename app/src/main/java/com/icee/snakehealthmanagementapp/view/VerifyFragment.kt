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
import com.icee.snakehealthmanagementapp.databinding.FragmentVerifyBinding
import com.icee.snakehealthmanagementapp.viewmodel.VerifyData

class VerifyFragment: Fragment(){
    private lateinit var binding: FragmentVerifyBinding
    private val viewmodel by viewModels<VerifyData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_verify, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewmodel

        viewmodel.clickedState.observe(viewLifecycleOwner) toError@ {
            when(it) {
                ClickedState.RESET -> {
                    if(viewmodel.checkCode()) return@toError
                    findNavController().navigate(R.id.verify_to_reset)
                }
                ClickedState.LOGIN -> findNavController().navigate(R.id.verify_to_login)
            }
        }

        return binding.root
    }
}
