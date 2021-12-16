package com.example.practice.presenter

import com.example.practice.NoteModel
import com.example.practice.model.NoteDatabase

interface VPagerPresenter {
    fun noteData(): List<NoteModel>
    fun saveFromPager()
}