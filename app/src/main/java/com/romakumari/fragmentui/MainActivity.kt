package com.romakumari.fragmentui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    lateinit var navController: NavController
    lateinit var fragmentFitnessBinding: FragmentFitnessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.nav_Host)
                as androidx.navigation.fragment.NavHostFragment
        navController=navHostFragment.navController
        fragmentFitnessBinding.btnsignup.setOnClickListener {
            navController.navigate(R.id.signUpFragment)
        }
        fragmentFitnessBinding.btnsignin.setOnClickListener {
            navController.navigate(R.id.signInFragment)
        }
    }
}
