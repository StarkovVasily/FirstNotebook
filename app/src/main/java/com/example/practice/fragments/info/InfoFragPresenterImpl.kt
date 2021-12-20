package com.example.practice.fragments.info

import android.util.Log
import com.example.practice.NoteModel
import com.example.practice.model.NoteDatabase

class InfoFragPresenterImpl(
    var view: Info.View?,
    private var note: NoteModel?,
    private val db: NoteDatabase
) : InfoPresenter {

    override fun updateTitle(title: String) {
        note?.title = title
        Log.d("ya", "eblo1")
    }

    override fun updateText(text: String) {
        note?.text = text
        Log.d("ya", "eblo2")
    }

    override fun saveNote() {
        note?.let {
            db.noteDao().updateNote(it)
        }
    }

    override fun shareNote(title: String, text: String) {
        if (title.isEmpty() || title.isEmpty()) view?.showMessage("Заметка пуста")
        else {
            val note = if (title.isEmpty()) text
            else "${title}\n${text}"
            view?.shareText(note)
        }
    }
}