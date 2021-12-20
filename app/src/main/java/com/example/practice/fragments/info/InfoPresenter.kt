package com.example.practice.fragments.info

import android.util.Log

interface InfoPresenter {

    fun updateTitle(title: String)
    fun updateText(text: String)
    fun saveNote()
    fun shareNote(title: String, text: String)
}