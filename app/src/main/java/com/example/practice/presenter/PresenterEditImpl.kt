package com.example.practice.presenter

import android.annotation.SuppressLint
import com.example.practice.NoteModel
import com.example.practice.model.ListModel
import com.example.practice.view.EditNote
import com.example.practice.view.MainActivity.Constant.DATE_FORMAT
import java.text.SimpleDateFormat
import java.util.*

class PresenterEditImpl(var view: EditNote?) : PresenterEdit {
    @SuppressLint("SimpleDateFormat")
    override fun saveNote(title: String, text: String) {
        if (text.isEmpty())
            view?.messaging("Заметка $title пуста")
        else
            view?.messaging("Заметка $title сохранена")
        val dateFormat = SimpleDateFormat(DATE_FORMAT)
        val currentDate = dateFormat.format(Date())
        ListModel.addToList(NoteModel(title, text, currentDate))

    }

    override fun shareNote(title: String, text: String) {
        val note = if (title.isEmpty()) text
        else "${title}\n${text}"
        view?.share(note)
    }
}