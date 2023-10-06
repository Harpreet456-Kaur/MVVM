package com.example.mvvm.RoomDatabase

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvm.R
import com.example.mvvm.model.NoteEntity

@Database(entities = arrayOf(NoteEntity::class), version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        var noteDatabase: NoteDatabase? = null

        fun getDatabase(context: Context): NoteDatabase {
            if (NoteDatabase == null) {
                noteDatabase = Room.databaseBuilder(context, NoteDatabase::class.java,
                    context.resources.getString(R.string.app_name)
                ).build()
            }
            return noteDatabase!!
        }
    }
}