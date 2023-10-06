package com.example.mvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.NotesList
import com.example.mvvm.databinding.ShownoteBinding
import com.example.mvvm.model.NoteEntity

class NoteAdapter(var list: ArrayList<NoteEntity>, var itemListener: NotesList) : RecyclerView.Adapter<NoteAdapter.viewHolder>() {

    class viewHolder(val binding: ShownoteBinding): RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val binding = ShownoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return viewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.binding.name.text = list[position].name
        holder.binding.notes.text = list[position].note
    }

    fun setData(documents: ArrayList<NoteEntity>) {
        list.clear()
        list.addAll(documents)
        notifyDataSetChanged()
    }

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {


        itemListener = NotesList()
    }
}