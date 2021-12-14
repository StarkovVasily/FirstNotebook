package com.example.practice.presenter

import androidx.fragment.app.Fragment
import com.example.practice.NoteModel

interface MainPresenter {
    fun noteData(): List<NoteModel>
    fun openFragment(note: NoteModel)
    fun saveFromFrag2(title: String, text: String)
    fun shareFromFrag2(title: String, text: String)
}