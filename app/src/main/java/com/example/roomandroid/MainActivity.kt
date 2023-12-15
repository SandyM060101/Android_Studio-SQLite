package com.example.roomandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomandroid.databinding.ActivityMainBinding
import com.example.roomandroid.db.NoteRoomDatabase
import com.example.roomandroid.model.Note

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        getOnData()
    }

    private fun getOnData(){
        val database = NoteRoomDatabase.getDatabase(application)
        val dao = database.getNoteDao()
        val listItems = arrayListOf<Note>()
        listItems.addAll(dao.getAll())
        setupRecyclerView(listItems)

    }

    private fun setupRecyclerView(listItems:ArrayList<Note>){
        binding.recycleViewMain.apply {
            adapter = NoteAdapter(listItems, object  : NoteAdapter.NoteListener(){
                override fun OnItemClicked(note: ContactsContract.CommonDataKinds.Note) {
                    TODO("Not yet implemented")
                }

            })

            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    override fun onResume() {
        super.onResume()
        getOnData()
    }


}