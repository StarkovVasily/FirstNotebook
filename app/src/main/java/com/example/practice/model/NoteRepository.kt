package com.example.practice.model

import androidx.lifecycle.LiveData
import com.example.practice.NoteModel

interface NoteRepository {

    fun getNotes(): List<NoteModel>
    fun insertNote(note: NoteModel)
    fun updateNote(note: NoteModel)
}