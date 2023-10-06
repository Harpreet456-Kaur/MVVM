package com.example.mvvm.model

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.mvvm.addnotes
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SuppressLint("StaticFieldLeak")
object Common {

    const val DATABASE_NAME = "note_database"
    private var lastClickedButton: Button? = null

    fun toast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT)
            .show()
    }

    fun onButtonClicked(clickedButton: Button, clicked: Int): Int {
        lastClickedButton?.setBackgroundColor(Color.parseColor("#2196f3"))
        lastClickedButton = clickedButton

        clickedButton.setBackgroundColor(Color.GREEN)
        Log.d("TAG", "$clicked")
        return clicked
    }

    //    Here are checking the if the Title or Note is empty or not
    fun checkNameAndNote(context: addnotes, name: String, note: String): Boolean {

        return when {
            name.isEmpty() -> {
                false
            }

            note.isEmpty() -> {
                false
            }

            else -> {
                true
            }
        }
    }
}