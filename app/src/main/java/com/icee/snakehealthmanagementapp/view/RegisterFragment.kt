package com.icee.snakehealthmanagementapp.view

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.icee.snakehealthmanagementapp.R
import com.icee.snakehealthmanagementapp.constant.ClickedState
import com.icee.snakehealthmanagementapp.databinding.FragmentRegisterBinding
import com.icee.snakehealthmanagementapp.util.toBinary
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

        viewmodel.clickedState.observe(viewLifecycleOwner) toError@ {
            when(it) {
                ClickedState.MAIN -> {
                    if (viewmodel.checkName()) return@toError
                    (activity as MainActivity).navMain()
                }
                ClickedState.LOGIN -> findNavController().navigate(R.id.register_to_login)
                ClickedState.ICON -> {
                    // 権限を持っている場合
                    if (ContextCompat.checkSelfPermission(this.requireContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        displayGallery()
                    } else { // 権限を持っていない場合
                        requestPermissions()
                    }
                }
            }
        }
        return binding.root
    }

    private fun requestPermissions() {
        requestPermissionsLauncher.launch(arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE
        ))
    }

    private val requestPermissionsLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
                grantStates: Map<String, Boolean> ->
            grantStates.forEach {
                if (it.value){ // 権限のリクエストを許可した時
                    displayGallery()
            }
        }
    }

    private fun displayGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startForResult.launch(intent)
    }

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result: ActivityResult? ->
        if (result?.resultCode == Activity.RESULT_OK && result.data?.data != null) {
            binding.icon.setImageURI(result.data?.data)
            val binary = result.data?.data?.toBinary(this.requireContext())
            // Api.updateIcon(binary)
        }
    }
}
