package com.example.practice.fragments.info



interface InfoPresenter {
    fun shareNote(title: String, text: String)
    fun save(title: String, text: String, id:Int?)
}