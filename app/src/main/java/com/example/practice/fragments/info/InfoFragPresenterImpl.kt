package com.example.practice.fragments.info

import com.example.practice.NoteModel
import com.example.practice.model.NoteDatabase
import java.util.*

class InfoFragPresenterImpl(
    var view: Info.View?,
    private var note: NoteModel?,
    private val db: NoteDatabase
) : InfoPresenter {


    override fun shareNote(title: String, text: String) {
        if (title.isEmpty() || text.isEmpty()) view?.showMessage("Заметка пуста")
        else {
            val note = if (title.isEmpty()) text
            else "${title}\n${text}"
            view?.shareText(note)
        }
    }

    override fun save(title: String, text: String) {
        if (note?.id != null)
            note?.let {
                it.title = title
                it.text = text
                db.noteDao().updateNote(it)
            }
        else {
            val date = Calendar.getInstance().time
            if (title.isEmpty() && text.isEmpty()) view?.showMessage("Заметка пуста")
            else
                db.noteDao().insert(NoteModel(title = title, text = text, date = date.toString()))
        }
    }
}