package com.example.practice.model

import android.util.Log
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.practice.NoteModel

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes")
    fun getNotes(): List<NoteModel>

    @Insert
    fun insert(note: NoteModel)

    @Update
    fun updateNote(note: NoteModel)
}