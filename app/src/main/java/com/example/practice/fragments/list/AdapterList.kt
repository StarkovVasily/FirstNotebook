package com.example.practice.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.NoteModel
import com.example.practice.R
import com.example.practice.databinding.RecyclerItemBinding
import com.example.practice.fragments.info.FragmentInfo
import com.example.practice.view.MainActivity
import com.example.practice.view.MainActivity.Constant.TITLE_KEY


class AdapterList(private val list: ArrayList<NoteModel>, private var activity: MainActivity?) :
    RecyclerView.Adapter<AdapterList.ViewHolderList>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderList {
        return ViewHolderList(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.recycler_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolderList, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolderList(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = RecyclerItemBinding.bind(item)

        fun bind(item: NoteModel) = with(binding) {
            if (item.title.isEmpty())
                recyclerTitle.text=item.text
            else
                recyclerTitle.text = item.title
            cardList.setOnClickListener {
                val bundle = Bundle().apply {
                    putSerializable(TITLE_KEY, item)
                }
                val fragManage = FragmentInfo.newInstance()
                fragManage.arguments = bundle
                activity?.openFrag(fragManage)
            }
        }
    }
}