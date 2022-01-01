package com.example.practice.view

import com.example.practice.fragments.info.InfoFragment

interface Save {
    var currentFragment: InfoFragment?
    fun save()
}