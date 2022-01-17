package com.example.practice.fragments.info

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practice.NoteModel
import com.example.practice.model.NoteDatabase
import com.example.practice.model.NoteRepository
import java.util.*

class InfoFragViewModel(private val db: NoteRepository) : ViewModel() {

    private val noteTitleMutable = MutableLiveData<String>()
    val noteTitle: LiveData<String> = noteTitleMutable

    private val noteTextMutable = MutableLiveData<String>()
    val noteText: LiveData<String> = noteTextMutable

    private val noteForShareMutable = MutableLiveData<String>()
    val noteForShare: LiveData<String> = noteForShareMutable

    fun saveNote(id: Int?, title: String, text: String) {
        val date = Calendar.getInstance().time
        id?.let {
            db.updateNote(
                NoteModel(
                    id = id.toLong(),
                    title = title,
                    text = text,
                    date = date.toString()
                )
            )
        } ?: run {
            if (title.isNotEmpty() && text.isNotEmpty())
                db.insertNote(NoteModel(title = title, text = text, date = date.toString()))
        }
    }

    fun shareNote(title: String, text: String) {
        noteForShareMutable.value = if (title.isEmpty()) text
        else "${title}\n${text}"
    }

}