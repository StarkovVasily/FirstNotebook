package com.example.practice.fragments.list

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practice.databinding.FragmentListBinding
import com.example.practice.presenter.MainPresenterImpl
import com.example.practice.view.EditNoteActivity
import com.example.practice.view.OpenFragment


class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            val presenter = MainPresenterImpl()
            recycler.adapter = ListAdapter(presenter.noteData(), activity as? OpenFragment)
            buttonAdd.setOnClickListener {
                requireActivity()
                    .startActivity((Intent(activity?.baseContext, EditNoteActivity::class.java)))
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }
}