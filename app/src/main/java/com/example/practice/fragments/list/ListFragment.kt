package com.example.practice.fragments.list

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practice.R
import com.example.practice.databinding.FragmentListBinding
import com.example.practice.fragments.info.InfoFragment
import com.example.practice.presenter.MainPresenterImpl
import com.example.practice.view.EditNoteActivity
import com.example.practice.view.MainActivity
import com.example.practice.view.MainView


class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var presenter: MainPresenterImpl
    private lateinit var adapter: ListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        presenter = MainPresenterImpl(requireActivity() as? MainView)
        adapter = ListAdapter {
            presenter.openFragment(it)
        }
        recycler.adapter = adapter
        buttonAdd.setOnClickListener {
            requireActivity()
                .startActivity(
                    (Intent(
                        activity?.baseContext,
                        EditNoteActivity::class.java
                    ))
                )
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }
}
