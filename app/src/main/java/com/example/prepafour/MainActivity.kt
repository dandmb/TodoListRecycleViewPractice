package com.example.prepafour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import com.example.prepafour.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private var noteList= listOf<Note>(
        Note("Sample note 1", "Sample text here"),
        Note("Sample note 2","Sample text here"),
        Note("Sample note 3","Sample text here"),
        Note("Sample note 4", "Sample text here"),
        Note("Sample note 5","Sample text here"),
        Note("Sample note 6","Sample text here"),
    )

    private val noteAdapter=NoteAdapter(onNoteDeleteClick = {
        onDeleteNote(it)
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyCleV.adapter=noteAdapter
        noteAdapter.submitList(noteList)

        binding.button.setOnClickListener{
            addNote()
        }


    }

    private fun onDeleteNote(note:Note){
        noteList=noteList.toMutableList().apply {
            remove(note)
        }

        noteAdapter.submitList(noteList)
    }
    private fun addNote(){
        val title=binding.editTexttitle.text?.toString()
        if (title.isNullOrBlank()){
            Snackbar.make(binding.root,"Please write title",Snackbar.LENGTH_SHORT).show()
            return
        }
        val text=binding.editTextText.text
        if (text.isNullOrBlank()){
            Snackbar.make(binding.root,"Please write text",Snackbar.LENGTH_SHORT).show()
            return
        }

    }
}