package com.uc.forestq.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uc.forestq.R
import com.uc.forestq.databinding.ActivityMainBinding
import com.uc.forestq.databinding.ActivitySigninBinding

class SigninActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
    }
}