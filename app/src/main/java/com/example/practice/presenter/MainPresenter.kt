package com.example.practice.presenter

import androidx.fragment.app.Fragment
import com.example.practice.NoteModel
import com.example.practice.fragments.list.ListAdapter

interface MainPresenter {
    fun noteData(): List<NoteModel>
    fun openFragment(note: NoteModel)
    fun saveFromFrag2(note: NoteModel)
    fun shareFromFrag2(title: String, text: String)
}