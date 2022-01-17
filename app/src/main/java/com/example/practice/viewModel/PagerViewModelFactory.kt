package com.example.practice.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.model.NoteRepository

class PagerViewModelFactory(private val db: NoteRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PagerViewModel(db) as T
    }
}