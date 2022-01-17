package com.example.practice.infoVMTest

import com.example.practice.NoteModel
import com.example.practice.fragments.info.InfoFragViewModel
import com.example.practice.model.NoteRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito
import org.mockito.Mockito.mock

@RunWith(JUnit4::class)
class InfoFragViewModelTest {

    private lateinit var repository: NoteRepository
    private lateinit var vm: InfoFragViewModel

    @Before
    fun setUp() {
        repository = mock(NoteRepository::class.java)
        vm = InfoFragViewModel(repository)
    }

    @Test
    fun testSaveNote() {
        vm.saveNote(1, "title", "text")
        Mockito.verify(repository).updateNote((NoteModel(1, "title", "text", "19.09.1999")))
        Mockito.verify(repository).insertNote((NoteModel(1, "title", "text", "19.09.1999")))
    }
}
