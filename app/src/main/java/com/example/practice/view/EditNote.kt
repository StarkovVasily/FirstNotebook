package com.example.practice.view

interface EditNote {
    fun messaging(message: String)
    fun share(note: String)
    fun showDialog(title: String, text: String)
}