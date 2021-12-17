package com.example.practice.fragments.list

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practice.databinding.FragmentListBinding
import com.example.practice.model.NoteDatabase
import com.example.practice.presenter.MainPresenterImpl
import com.example.practice.view.EditNoteActivity
import com.example.practice.view.MainView
import com.example.practice.view.ViewPagerActivity
import com.example.practice.view.ViewPagerActivity.Constant.EXTRA_KEY


class ListFragment : Fragment(), MainView.View {
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
        presenter = MainPresenterImpl(
            requireActivity() as? MainView.Fragments?,
            NoteDatabase.getInstance(requireContext())
        )
        adapter = ListAdapter(presenter.noteData()) {
            val intent = Intent(activity?.baseContext, ViewPagerActivity::class.java)
            intent.putExtra(EXTRA_KEY, it.id)
            startActivity(intent)
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

    override fun onResume() {
        super.onResume()
        updateData()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateData() {
        adapter.updateData(presenter.noteData())
        adapter.notifyDataSetChanged()
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }
}
