package com.example.mvvm.model

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AddNoteViewModelFactory(private val addNoteActivity: Application) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(com.example.mvvm.model.ViewModel::class.java)) {
            return com.example.mvvm.model.ViewModel(addNoteActivity) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}