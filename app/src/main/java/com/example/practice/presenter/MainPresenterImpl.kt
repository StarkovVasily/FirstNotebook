package com.example.practice.presenter


import com.example.practice.NoteModel
import com.example.practice.model.NoteDatabase
import com.example.practice.view.MainView
import java.util.*


class MainPresenterImpl(var item: MainView.Fragments?, private val db: NoteDatabase) : MainPresenter {

    override fun noteData(): List<NoteModel> = db.noteDao().getNotes()
    override fun openFragment(note: NoteModel) {
        item?.openInfoFragment(note)
    }

    override fun saveFromFrag2(title: String, text: String) {
        if (text.isEmpty())
            item?.messagingFromFrag2("Заметка $title пуста")
        else
            item?.messagingFromFrag2("Заметка $title сохранена")
        val date = Calendar.getInstance().time
        db.noteDao().insert(NoteModel(title = title, text = text, date = date.toString()))
    }

    override fun shareFromFrag2(title: String, text: String) {
        val note = if (title.isEmpty()) text
        else "${title}\n${text}"
        item?.shareFromFrag2(note)
    }
}