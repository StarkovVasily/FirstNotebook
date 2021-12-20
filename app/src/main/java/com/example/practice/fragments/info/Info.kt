package com.example.practice.fragments.info

interface Info {
    interface View {
        fun showMessage(message: String)
        fun shareText(note: String)
        fun share()
        fun save()
    }
}