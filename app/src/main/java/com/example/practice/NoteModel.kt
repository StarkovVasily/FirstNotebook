package com.example.practice

import java.io.Serializable

data class NoteModel(
    val title:String,
    val text:String,
    val date:String
):Serializable
