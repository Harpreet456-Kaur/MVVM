package com.example.mvvm.RoomDatabase

import android.app.Application
import androidx.room.Room

class NoteApplication : Application() {
    companion object {
        lateinit var database: NoteDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, NoteDatabase::class.java, "todo-db").build()
    }
}