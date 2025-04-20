package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.data.AppDatabase
import com.example.myapplication.model.data.Note
import kotlinx.coroutines.launch

class NoteViewModel(private val database: AppDatabase) : ViewModel() {
    fun insertNote(topic: String, content: String) {
        val note = Note(topic = topic, content = content)
        viewModelScope.launch {
            database.noteDao().insert(note)
        }
    }
}