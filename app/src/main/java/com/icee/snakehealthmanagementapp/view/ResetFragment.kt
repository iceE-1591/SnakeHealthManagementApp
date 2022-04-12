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
import com.icee.snakehealthmanagementapp.databinding.FragmentResetBinding
import com.icee.snakehealthmanagementapp.viewmodel.ResetData

class ResetFragment: Fragment(){
    private lateinit var binding: FragmentResetBinding
    private val viewmodel by viewModels<ResetData>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_reset, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewmodel

        viewmodel.clickedState.observe(viewLifecycleOwner) toError@ {
            when(it) {
                ClickedState.MAIN -> {
                    if(viewmodel.checkPassword()) return@toError
                    if(viewmodel.checkConfirmPassword()) return@toError
                    (activity as MainActivity).navMain()
                }
                ClickedState.LOGIN -> findNavController().navigate(R.id.reset_to_login)
            }
        }

        return binding.root
    }
}
