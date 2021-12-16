package com.example.practice.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.practice.NoteModel

@Dao
interface DAO {

    @Query("SELECT * FROM notes")
    fun getNotes(): List<NoteModel>

    @Insert
    fun insert(note: NoteModel)

}