package com.example.practice.fragments.list


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.NoteModel
import com.example.practice.R
import com.example.practice.databinding.RecyclerItemBinding
import com.example.practice.model.ListModel.notes
import com.example.practice.presenter.MainPresenterImpl


class ListAdapter(private val onClick: ((NoteModel) -> Unit)) :
    RecyclerView.Adapter<ListAdapter.ViewHolderList>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderList {
        return ViewHolderList(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.recycler_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolderList, position: Int) {
        holder.bind(notes[position])
    }

    override fun getItemCount(): Int = notes.size

    inner class ViewHolderList(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = RecyclerItemBinding.bind(item)

        fun bind(item: NoteModel) = with(binding) {
            recyclerTitle.text = if (item.title.isEmpty()) item.text else item.title
            cardList.setOnClickListener {
                onClick(item)
            }
        }
    }
}