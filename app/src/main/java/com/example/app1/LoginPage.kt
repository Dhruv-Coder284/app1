package com.example.app1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app1.databinding.ActivityLoginPageBinding



class LoginPage : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.map.setOnClickListener{
            var intent = Intent(this,maps::class.java)
            startActivity(intent)
        }
        binding.car.setOnClickListener{
            var intent = Intent(this,Model::class.java)
            startActivity(intent)
        }
        }
    }
