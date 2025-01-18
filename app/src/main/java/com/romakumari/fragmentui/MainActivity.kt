package com.romakumari.fragmentui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.romakumari.fragmentui.databinding.ActivityMainBinding
import com.romakumari.fragmentui.databinding.ActivitySplashScreenBinding
import com.romakumari.fragmentui.databinding.FragmentFitnessBinding
import com.romakumari.fragmentui.databinding.FragmentSignInBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        }
    }

