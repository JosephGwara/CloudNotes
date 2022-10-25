package com.josephgwara.cloudnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.josephgwara.cloudnotes.databinding.ActivityLoginBinding
import com.josephgwara.cloudnotes.databinding.ActivityMainBinding
import com.josephgwara.cloudnotes.databinding.ActivityNoteDetailsBinding



private lateinit var binding: ActivityNoteDetailsBinding

class NoteDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveNoteBtn.setOnClickListener {
            saveNote()
        }
    }

    private fun saveNote() {
       var noteTitle:String = binding.notesTitleText.toString()
        var noteContent:String = binding.notesContentText.toString()

        if (binding.notesTitleText == null|| binding.notesTitleText.toString() ==""){

            binding.notesTitleText.error = "Title is required"
            return
        }
    }
}