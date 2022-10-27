package com.josephgwara.cloudnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.Query
import com.josephgwara.cloudnotes.databinding.ActivityMainBinding


private lateinit var binding: ActivityMainBinding
 private lateinit var noteAdapter:NoteAdapter
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addBtn.setOnClickListener {
            val intent = Intent(this, NoteDetailsActivity::class.java)
            startActivity(intent)
    }
        binding.menuBtn.setOnClickListener {
            showMenu()
        }
        setupRecyclerView()
}

    private fun setupRecyclerView() {
        var utility = Utility()
        var query:Query = utility.getCollectionReferenceForNotes().orderBy("timestamp",Query.Direction.DESCENDING)
        var options:FirestoreRecyclerOptions<NoteModel> = FirestoreRecyclerOptions.Builder<NoteModel>()
            .setQuery(query,NoteModel::class.java).build()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        noteAdapter = NoteAdapter(options)
        binding.recyclerView.adapter = noteAdapter
    }

    override fun onStart() {
        super.onStart()
        noteAdapter.startListening()

    }

    override fun onStop() {
        super.onStop()
        noteAdapter.stopListening()
    }

    override fun onResume() {
        super.onResume()
        noteAdapter.notifyDataSetChanged()
    }
    private fun showMenu() {
        TODO("Not yet implemented")
    }
}