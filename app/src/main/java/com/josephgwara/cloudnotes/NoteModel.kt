package com.josephgwara.cloudnotes

import com.google.firebase.Timestamp

data class NoteModel(var title:String, var content:String, var timestamp: Timestamp ){

    constructor():this("","", Timestamp.now() )
}
