package com.example.practice.fragments.info

import android.util.Log
import com.example.practice.NoteModel
import com.example.practice.model.NoteDatabase
import java.util.*

class InfoFragPresenterImpl(
    var view: Info.View?,
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

    override fun save(title: String, text: String, id: Int?) {
        val date = Calendar.getInstance().time
        id?.let {
            db.noteDao().updateNote(
                NoteModel(
                    id = it.toLong(),
                    title = title,
                    text = text,
                    date = date.toString()
                )
            )
        }
        if (title.isEmpty() && text.isEmpty()) view?.showMessage("Заметка пуста")
        else
            db.noteDao().insert(NoteModel(title = title, text = text, date = date.toString()))
    }
}