package com.example.practice.presenter

import com.example.practice.NoteModel
import com.example.practice.model.ListModel

class MainPresenterImpl:MainPresenter {
    override fun noteData(): ArrayList<NoteModel> = ListModel.notes
}