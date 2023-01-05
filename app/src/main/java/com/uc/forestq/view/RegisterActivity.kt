package com.uc.forestq.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uc.forestq.databinding.ActivityMainBinding
import com.uc.forestq.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

    }

    private fun listener() {
        binding.backImageButtonRegister.setOnClickListener() {
            val myIntent = Intent(this, AuthPageActivity::class.java)
            startActivity(myIntent);
        }
    }
}