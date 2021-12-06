package com.example.practice.model


import com.example.practice.NoteModel

object ListModel {
    val notes=ArrayList<NoteModel>().apply {
        add(NoteModel("smth №1","У меня плохо получается придумывать что нибудь интересное","03.12.2021"))
        add(NoteModel("smth №2","Ну правда","04.12.2021"))
        add(NoteModel("smth №3","С воображением не очень","05.12.2021"))
        add(NoteModel("smth №4","TTMD","06.12.2021"))
    }
    fun addToList(noteModel:NoteModel){
        notes.add(noteModel)
    }
}