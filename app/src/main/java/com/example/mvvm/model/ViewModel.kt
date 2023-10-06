package com.example.mvvm.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mvvm.RoomDatabase.NoteDatabase
import com.example.mvvm.RoomDatabase.NoteRepository

class ViewModel(application: Application) : AndroidViewModel(application){

    private val noteRepository: NoteRepository
    val allNotes: LiveData<List<NoteEntity>>

    init {
        val dao = NoteDatabase.getDatabase(application).noteDao()
        noteRepository = NoteRepository(dao)
        allNotes = noteRepository.allNotes

    }

    fun insert(noteEntity: NoteEntity) {
        noteRepository.insertNotes(noteEntity)
    }

    fun getNotes(noteEntity: NoteEntity): LiveData<List<NoteEntity>> = noteRepository.allNotes

    fun deleteNote(noteEntity: NoteEntity) {
        noteRepository.deleteNotes(NoteEntity())
    }

    fun updateNote(noteEntity: NoteEntity) {
        noteRepository.updateNotes(noteEntity)
    }
}