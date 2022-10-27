package com.josephgwara.cloudnotes

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentReference
import com.josephgwara.cloudnotes.databinding.ActivityNoteDetailsBinding



class NoteDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteDetailsBinding
    private var isEditMode = false

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var title: String? = intent.getStringExtra("title")
        var content: String? = intent.getStringExtra("content")
        var docId: String? = intent.getStringExtra("docId")




        if(docId != null && docId.toString().isNotEmpty()){
            isEditMode = true
        }

        binding.notesTitleText.setText(title)
        binding.notesContentText.setText(content)

        if (isEditMode){
            binding.pageTitle.text = "Edit your Note"
        }

        binding.saveNoteBtn.setOnClickListener {
            if (binding.notesTitleText.text.toString().isEmpty()){
                binding.notesTitleText.error = "Title is required"
            }
            else{
                saveNote()
            }

        }
    }

    private fun saveNote() {

        val noteModel = NoteModel(binding.notesTitleText.text.toString(),binding.notesContentText.text.toString(), Timestamp.now())

        saveNoteToFirebase(noteModel)


    }

    private fun saveNoteToFirebase(noteModel: NoteModel) {
        var docId: String? = intent.getStringExtra("docId")
     val documentReference:DocumentReference
     val utility = Utility()
        documentReference = if (isEditMode){

            utility.getCollectionReferenceForNotes().document(docId.toString())
        } else{
            utility.getCollectionReferenceForNotes().document()
        }

        documentReference.set(noteModel).addOnCompleteListener {
            if(it.isSuccessful){
                utility.showToast(this,"Note Added Successfully ")
                finish()
            }
            else{
                utility.showToast(this,"Failed While adding Note ")
            }


        }

    }
}