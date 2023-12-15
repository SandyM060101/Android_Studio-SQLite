package com.example.roomandroid

import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(
    private val listItems: ArrayList<com.example.roomandroid.model.Note>,
    private val listener: NoteListener

):RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var textViewTitle = itemView.findViewById<TextView>(R.id.text_view_title)
        var textViewBody = itemView.findViewById<TextView>(R.id.text_view_body)
    }

    abstract class NoteListener{
        abstract fun OnItemClicked(note: Note)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent,false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItems.size

    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val item = listItems[position]
        holder.textViewTitle.text = item.title
        holder.textViewBody.text = item.body
        holder.itemView.setOnClickListener{
        }
    }
}