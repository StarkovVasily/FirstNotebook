package com.example.practice.presenter

interface PresenterEdit {
    fun saveNote(title: String, text: String)
    fun shareNote(title: String, text: String)
    fun titleToMain(title: String, text: String)
}