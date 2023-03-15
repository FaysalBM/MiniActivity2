package com.example.miniactivity2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.miniactivity2.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Activity2Binding.inflate(layoutInflater)

        binding.messageResult.text = intent.getStringExtra("messageInput")?.repeat(intent.getIntExtra("repsInput", 0))

        binding.backButton.setOnClickListener {
            setResult(
                RESULT_OK,
                Intent().putExtra("messageResult", binding.messageResult.text.toString())
            )
            finish()
        }

        setContentView(binding.root)
    }
}