package com.icee.snakehealthmanagementapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.icee.snakehealthmanagementapp.R
import com.icee.snakehealthmanagementapp.databinding.Fragment2Binding
import com.icee.snakehealthmanagementapp.viewmodel.Fragment2Data

class Fragment2: Fragment(){
    private lateinit var binding: Fragment2Binding
    private val viewmodel by viewModels<Fragment2Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment2, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewmodel
        return binding.root
    }
}