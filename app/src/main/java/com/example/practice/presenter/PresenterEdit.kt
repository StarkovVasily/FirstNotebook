package com.example.practice.presenter

import com.example.practice.view.ViewEditInterface

class PresenterEdit(var view: ViewEditInterface?) : PresenterEditInterface {
    override fun saveNote(title: String, text: String) {
        if(text.isEmpty())
        view?.messaging("Заметка $title пуста")
            else
        view?.messaging("Заметка $title сохранена")
    }
}