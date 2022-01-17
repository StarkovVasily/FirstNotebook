package com.example.practice.fragments.list

import androidx.lifecycle.ViewModel
import com.example.practice.NoteModel
import com.example.practice.model.NoteRepository

class ListViewModel(private val db: NoteRepository) : ViewModel() {
    fun noteData(): List<NoteModel> = db.getNotes()
}