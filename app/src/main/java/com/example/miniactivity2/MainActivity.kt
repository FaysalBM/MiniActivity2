package com.example.miniactivity2

import android.os.Bundle
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.miniactivity2.databinding.ActivityMainBinding

lateinit var getContent : ActivityResultLauncher<Intent>
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBye.setOnClickListener {
            val messageInput = binding.message5.text.toString()
            val repsInput = binding.message3.text.toString().toIntOrNull()

            val intent = Intent(this, Activity2::class.java).apply {
                putExtra("messageInput", messageInput)
                putExtra("repsInput", repsInput)
            }
            getContent.launch(intent)
        }

        getContent = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { input ->
            if (input?.resultCode == RESULT_OK) {
                val messageInput = input.data?.getStringExtra("messageInput")
                binding.message6.text = messageInput
                binding.message5.text.clear()
                binding.message3.text.clear()
                binding.message3.requestFocus()
            }
        }
    }


}