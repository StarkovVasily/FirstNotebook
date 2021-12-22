package com.example.practice.presenter


import com.example.practice.NoteModel
import com.example.practice.model.NoteDatabase


class MainPresenterImpl(private val db: NoteDatabase) :
    MainPresenter {

    override fun noteData(): List<NoteModel> = db.noteDao().getNotes()
}