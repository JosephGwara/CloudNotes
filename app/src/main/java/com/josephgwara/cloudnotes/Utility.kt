package com.josephgwara.cloudnotes

import android.content.Context
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.widget.Toast
import com.google.firebase.Timestamp
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
    fun timeStampString(timestamp: Timestamp):String{

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            SimpleDateFormat("MM/dd/yyyy").format(timestamp.toDate())
        } else {
            TODO("VERSION.SDK_INT < N")
        }

    }
}