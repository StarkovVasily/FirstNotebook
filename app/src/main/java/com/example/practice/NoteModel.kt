package com.example.practice


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NoteModel(
    val title: String,
    val text: String,
    val date: String
) : Parcelable
