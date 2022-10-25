package com.josephgwara.cloudnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.josephgwara.cloudnotes.databinding.ActivityLoginBinding
import com.josephgwara.cloudnotes.databinding.ActivityMainBinding


private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addBtn.setOnClickListener {
            val intent = Intent(this, NoteDetailsActivity::class.java)
            startActivity(intent)
    }
}
}