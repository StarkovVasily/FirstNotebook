package com.example.practice.presenter

import com.example.practice.view.EditNote

class PresenterEditImpl(var view: EditNote?) : PresenterEdit {
    override fun saveNote(title: String, text: String) {
        if (text.isEmpty())
            view?.messaging("Заметка $title пуста")
        else
            view?.messaging("Заметка $title сохранена")
    }

    override fun shareNote(title: String, text: String) {
        val note = if (title.isEmpty()) text
        else "${title}\n${text}"
        view?.share(note)
    }

    override fun titleToMain(title: String, text: String) {
        if (title.isEmpty())
            view?.toMain(text)
        else
            view?.toMain(title)
    }
}