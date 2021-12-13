package com.example.practice.view

import androidx.fragment.app.Fragment
import com.example.practice.NoteModel

interface MainView {
    fun openFrag(id: Int, f: Fragment)
    fun openInfoFragment(note: NoteModel)
    fun shareFromFrag2(note: String)
    fun messagingFromFrag2(message: String)
}