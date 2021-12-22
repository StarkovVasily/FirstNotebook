package com.example.practice.presenter


import com.example.practice.NoteModel


interface MainPresenter {
    fun noteData(): List<NoteModel>
    fun openFragment(note: NoteModel)
}