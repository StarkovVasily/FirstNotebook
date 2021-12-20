package com.example.practice.viewPager

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.practice.NoteModel
import com.example.practice.R
import com.example.practice.databinding.FragmentInfoBinding
import com.example.practice.fragments.info.InfoFragment



class ViewPagerAdapter(fragment:FragmentActivity,private val note: List<NoteModel>) :
    FragmentStateAdapter(fragment) {

//    var title: String? = null
//    var text: String? = null
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
//        return ViewPagerHolder(
//            LayoutInflater
//                .from(parent.context)
//                .inflate(R.layout.fragment_info, parent, false)
//        )
//    }
//
//    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
//        holder.bind(note[position])
//    }


    override fun getItemCount(): Int = note.size

    override fun createFragment(position: Int): Fragment =
        InfoFragment.newInstance(note[position])
}


//
//    fun getItem(position: Int): NoteModel =
//        NoteModel(
//            note[position].id,
//            if (title == null) note[position].title
//            else title.toString(),
//            if (text == null) note[position].text
//            else text.toString(),
//            note[position].date
//        )
//
//    override fun getItemId(position: Int) = note[position].id
//
//    inner class ViewPagerHolder(item: View) : RecyclerView.ViewHolder(item) {
//        private var binding = FragmentInfoBinding.bind(item)
//
//        fun bind(item: NoteModel) = with(binding) {
//            frag2Title.setText(item.title)
//            frag2Text.setText(item.text)
//            frag2Date.text = item.date
//
//            frag2Title.addTextChangedListener(object : TextWatcher {
//                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
//
//                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
//
//                override fun afterTextChanged(p0: Editable?) {
//                    title = p0.toString()
//                }
//            })
//            frag2Text.addTextChangedListener(object : TextWatcher {
//                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
//
//                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
//
//                override fun afterTextChanged(p0: Editable?) {
//                    text = p0.toString()
//                }
//            })
//        }
//    }
//}