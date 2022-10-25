package com.josephgwara.cloudnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentReference
import com.josephgwara.cloudnotes.databinding.ActivityNoteDetailsBinding



class NoteDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        var noteModel = NoteModel(binding.notesTitleText.text.toString(),binding.notesContentText.text.toString(), Timestamp.now())

        saveNoteToFirebase(noteModel)


    }

    private fun saveNoteToFirebase(noteModel: NoteModel) {
     var documentReference:DocumentReference
     var utility = Utility()
        documentReference = utility.getCollectionReferenceForNotes().document()
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