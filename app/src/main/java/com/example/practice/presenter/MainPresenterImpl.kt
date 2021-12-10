package com.example.practice.presenter


import android.provider.ContactsContract
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.practice.NoteModel
import com.example.practice.model.ListModel
import com.example.practice.view.MainView
import java.util.*
import kotlin.collections.ArrayList

class MainPresenterImpl(var item: MainView?) : MainPresenter {

    override fun noteData(): ArrayList<NoteModel> = ListModel.notes
    override fun openFragment(note: NoteModel) {
        item?.openInfoFragment(note)
    }

    override fun saveFromFrag2(title: String, text: String) {
        if (text.isEmpty())
            item?.messagingFromFrag2("Заметка $title пуста")
        else
            item?.messagingFromFrag2("Заметка $title сохранена")
        val date = Calendar.getInstance().time
        ListModel.addToList(NoteModel(title, text, date.toString()))
    }

    override fun shareFromFrag2(title: String, text: String) {
        val note = if (title.isEmpty()) text
        else "${title}\n${text}"
        item?.shareFromFrag2(note)
    }
}