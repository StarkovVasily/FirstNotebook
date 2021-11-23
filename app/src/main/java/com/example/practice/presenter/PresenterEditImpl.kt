package com.example.practice.presenter

import com.example.practice.view.ViewEdit

class PresenterEditImpl(var view: ViewEdit?) : PresenterEdit {
    override fun saveNote(title: String, text: String) {
        if (text.isEmpty())
            view?.messaging("Заметка $title пуста")
        else
            view?.messaging("Заметка $title сохранена")
    }
}