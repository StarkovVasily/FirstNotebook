package com.example.practice.view

import androidx.fragment.app.Fragment

interface MainView {
    interface View {
        fun showSaveShare()
        fun hideSaveShare()
    }

    interface Fragments {
        fun openFrag(f: Fragment, toStack: Boolean)
    }
}