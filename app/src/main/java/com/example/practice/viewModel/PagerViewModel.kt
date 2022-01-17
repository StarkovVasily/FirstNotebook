package com.example.practice.viewModel


import androidx.lifecycle.ViewModel
import com.example.practice.NoteModel
import com.example.practice.model.NoteRepository

class PagerViewModel(private val db: NoteRepository) : ViewModel() {

    fun noteData(): List<NoteModel> = db.getNotes()
}