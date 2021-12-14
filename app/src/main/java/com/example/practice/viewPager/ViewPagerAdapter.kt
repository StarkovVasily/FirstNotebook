package com.example.practice.viewPager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.NoteModel
import com.example.practice.R
import com.example.practice.databinding.FragmentInfoBinding


class ViewPagerAdapter(private val note: List<NoteModel>) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        return ViewPagerHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.fragment_info, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        holder.bind(note[position])
    }

    override fun getItemCount(): Int = note.size

    inner class ViewPagerHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = FragmentInfoBinding.bind(item)
        fun bind(item: NoteModel) = with(binding) {
            frag2Title.text = item.title
            frag2Text.text = item.title
            frag2Date.text = item.date
        }
    }

}