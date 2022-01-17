package com.example.practice.fragments.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practice.model.NoteRepository
import com.example.practice.viewModel.PagerViewModel

class ListViewModelFactory(private val db: NoteRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListViewModel(db) as T
    }
}