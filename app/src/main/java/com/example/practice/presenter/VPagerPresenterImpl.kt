package com.example.practice.presenter

import android.util.Log
import com.example.practice.NoteModel
import com.example.practice.fragments.info.InfoFragment
import com.example.practice.model.NoteDatabase
import com.example.practice.view.ViewPagerView

class VPagerPresenterImpl(var item: ViewPagerView?, private val db: NoteDatabase) :
    VPagerPresenter {

    override fun noteData(): List<NoteModel> = db.noteDao().getNotes()

    override fun saveFromPager(note: NoteModel) {
        db.noteDao().updateNote(note)
    }
}