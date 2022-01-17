package com.example.practice.viewPager


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.practice.NoteModel
import com.example.practice.fragments.info.InfoFragment


class ViewPagerAdapter(fragment: FragmentActivity, private val note: List<NoteModel>) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = note.size
    override fun createFragment(position: Int): Fragment =
        InfoFragment.newInstance(note[position])
}
