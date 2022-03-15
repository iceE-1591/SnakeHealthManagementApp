package com.icee.snakehealthmanagementapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.icee.snakehealthmanagementapp.R
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
        return binding.root
    }
}
