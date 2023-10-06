package com.example.mvvm.RoomDatabase

import androidx.lifecycle.LiveData
import com.example.mvvm.model.NoteEntity

class NoteRepository(private val noteDao: NoteDao) {

    val allNotes : LiveData<List<NoteEntity>> = noteDao.getAllTasks()

    fun insertNotes(noteEntity: NoteEntity) {
        return noteDao.insert(noteEntity)
    }

    fun deleteNotes(noteEntity: NoteEntity) {
        return noteDao.delete(noteEntity)
    }

    fun updateNotes(noteEntity: NoteEntity) {

    }

//    fun updateNotes(noteEntity: NoteEntity) {
//        return noteDao.updateTask(noteEntity.id!!, noteEntity.name!!, noteEntity.note!!)
//    }
}