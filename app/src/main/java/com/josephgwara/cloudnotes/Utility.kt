package com.josephgwara.cloudnotes

import android.content.Context
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class Utility {

    fun showToast(context: Context,message: String){

        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()

    }
    fun getCollectionReferenceForNotes():CollectionReference{

        var currentUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser

       return FirebaseFirestore.getInstance().collection("notes").document(currentUser!!.uid).collection("my_notes")

    }
}