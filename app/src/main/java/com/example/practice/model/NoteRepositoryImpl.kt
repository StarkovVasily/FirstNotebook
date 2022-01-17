package com.example.practice.model

import android.content.Context
import com.example.practice.NoteModel

class NoteRepositoryImpl(context: Context) : NoteRepository {

    private val notesDB = NoteDatabase.getInstance(context)

    override fun getNotes(): List<NoteModel> = notesDB.noteDao().getNotes()

    override fun insertNote(note: NoteModel) {
        notesDB.noteDao().insert(note)
    }

    override fun updateNote(note: NoteModel) {
        notesDB.noteDao().updateNote(note)
    }

}