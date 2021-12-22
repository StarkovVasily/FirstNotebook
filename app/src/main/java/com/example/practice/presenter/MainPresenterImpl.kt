package com.example.practice.presenter


import com.example.practice.NoteModel
import com.example.practice.model.NoteDatabase
import com.example.practice.view.MainView



class MainPresenterImpl(var item: MainView.Fragments?, private val db: NoteDatabase) :
    MainPresenter {

    override fun noteData(): List<NoteModel> = db.noteDao().getNotes()
    override fun openFragment(note: NoteModel) {
        item?.openInfoFragment(note)
    }
}