package com.example.practice.view

import androidx.fragment.app.Fragment
import com.example.practice.NoteModel

interface MainView {
    interface View {
        fun showSaveShare()
        fun hideSaveShare()
    }

    interface Fragments {
        fun openFrag(f: Fragment, toStack: Boolean)
        fun openInfoFragment(note: NoteModel)
    }
}