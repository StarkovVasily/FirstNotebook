package com.example.practice.presenter


import com.example.practice.NoteModel
import com.example.practice.model.NoteDatabase


class VPagerPresenterImpl(private val db: NoteDatabase) :
    VPagerPresenter {

    override fun noteData(): List<NoteModel> = db.noteDao().getNotes()

}