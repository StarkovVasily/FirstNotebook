package com.example.practice.presenter

import com.example.practice.NoteModel
import com.example.practice.model.NoteDatabase
import com.example.practice.view.EditNote
import java.util.*

class PresenterEditImpl(var view: EditNote?, private val db: NoteDatabase) : PresenterEdit {
    override fun saveNote(title: String, text: String) {
        if (text.isEmpty())
            view?.messaging("Заметка $title пуста")
        else
            view?.messaging("Заметка $title сохранена")
        val date = Calendar.getInstance().time
        db.noteDao().insert(NoteModel(title = title, text = text, date = date.toString()))
    }

    override fun shareNote(title: String, text: String) {
        val note = if (title.isEmpty()) text
        else "${title}\n${text}"
        view?.share(note)
    }
}