package com.example.prepafour

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.prepafour.databinding.ActivityMainBinding
import com.example.prepafour.databinding.ItemNoteBinding

class NoteAdapter(private val onNoteDeleteClick:(Note)->Unit):ListAdapter<Note,NoteViewHolder>(NoteDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding=ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return NoteViewHolder(binding,onNoteDeleteClick)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note=currentList[position]
        holder.bind(note)
    }
}
object NoteDiffCallback:DiffUtil.ItemCallback<Note>(){
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem==newItem
    }

}

class NoteViewHolder(
    private val binding: ItemNoteBinding,
    private val onNoteDeleteClick:(Note)->Unit):ViewHolder(binding.root){

    fun bind(note:Note){
        binding.txtViewTitle.text=note.title
        binding.txtViewText.text=note.text
        binding.buttonDelete.setOnClickListener{
            onNoteDeleteClick(note)
        }
    }


}