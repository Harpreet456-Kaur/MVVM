package com.example.mvvm.RoomDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mvvm.model.NoteEntity

@Dao
interface NoteDao {

    @Insert
    fun insert(noteEntity: NoteEntity)

    @Delete
    fun delete(noteEntity: NoteEntity)

    @Query("SELECT * FROM noteEntity")
    fun getAllTasks(): LiveData<List<NoteEntity>>

//    @Query("UPDATE notes_table SET name = :name,note = :note WHERE id = :id")
//    fun updateTask(id : Int? , name: String?, note: String?)
}