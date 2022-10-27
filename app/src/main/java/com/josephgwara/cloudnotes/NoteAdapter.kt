package com.josephgwara.cloudnotes

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions


class NoteAdapter(options: FirestoreRecyclerOptions<NoteModel>) :
    FirestoreRecyclerAdapter<NoteModel, NoteAdapter.NoteViewHolder>(options) {



    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

       val titleTextView:TextView = itemView.findViewById(R.id.notesTitleTextView)
       val contentTextView:TextView = itemView.findViewById(R.id.notesContentTextView)
       val timestampTextView:TextView = itemView.findViewById(R.id.timeStampTextView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_note_item,parent,false))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int, note: NoteModel) {
       val context = holder.itemView.context
        val utility = Utility()
        holder.titleTextView.text = note.title
        holder.contentTextView.text = note.content
        holder.timestampTextView.text = utility.timeStampString(note.timestamp)

        holder.itemView.setOnClickListener {

            val intent = Intent(context,NoteDetailsActivity::class.java)

            intent.putExtra("title",note.title)
            intent.putExtra("content",note.content)
            val docId:String = this.snapshots.getSnapshot(position).id
            intent.putExtra("docId",docId)

            context.startActivity(intent)

        }

    }


}