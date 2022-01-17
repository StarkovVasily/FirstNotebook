package com.example.practice.fragments.info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.model.NoteDatabase
import com.example.practice.model.NoteRepository
import com.example.practice.viewModel.PagerViewModel

class InfoFragViewModelFactory(private val db: NoteRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return InfoFragViewModel(db) as T
    }
}