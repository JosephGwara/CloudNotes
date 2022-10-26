package com.josephgwara.cloudnotes

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.josephgwara.cloudnotes.databinding.ActivityNoteDetailsBinding

private lateinit var binding: ActivityNoteDetailsBinding

class NoteAdapter(options: FirestoreRecyclerOptions<NoteModel>,context: Context) :
    FirestoreRecyclerAdapter<NoteModel, NoteAdapter.NoteViewHolder>(options) {

   inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

       val titleTextView:TextView = itemView.findViewById<TextView>(R.id.notesTitleTextView)
       val contentTextView:TextView = itemView.findViewById<TextView>(R.id.notesContentTextView)
       val timestampTextView:TextView = itemView.findViewById<TextView>(R.id.timeStampTextView)





    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_note_item,parent,false))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int, note: NoteModel) {
        var utility = Utility()
        holder.titleTextView.setText(note.title)
        holder.contentTextView.setText(note.content)
        holder.timestampTextView.setText(utility.timeStampString(note.timestamp))

    }


}