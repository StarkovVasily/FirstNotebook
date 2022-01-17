package com.example.practice.fragments.info


import android.content.Intent
import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.practice.NoteModel
import com.example.practice.R
import com.example.practice.databinding.FragmentInfoBinding
import com.example.practice.model.NoteDatabase
import com.example.practice.model.NoteRepositoryImpl
import com.example.practice.view.MainActivity.Constant.TITLE_KEY
import com.example.practice.view.Save


class InfoFragment : Fragment(), Info.View {
    private lateinit var binding: FragmentInfoBinding
    private var item: NoteModel? = null

    private lateinit var vm: InfoFragViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (arguments != null && arguments?.containsKey(TITLE_KEY) == true) {
            item = arguments?.getParcelable(TITLE_KEY) as? NoteModel?
        }
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(
            this,
            InfoFragViewModelFactory(NoteRepositoryImpl(requireContext()))
        ).get(InfoFragViewModel::class.java)
        binding.apply {
            frag2Title.setText(item?.title)
            frag2Text.setText(item?.text)
            frag2Date.text = item?.date
        }
        observeForShare()
    }

    override fun onResume() {
        super.onResume()
        (activity as? Save)?.currentFragment = this
    }

    override fun save() = with(binding) {
        if (frag2Title.text.isEmpty() && frag2Text.text.isEmpty())
            Toast.makeText(requireContext(), R.string.empty_note_alert, Toast.LENGTH_SHORT).show()
        else
            vm.saveNote(
                item?.id?.toInt(),
                observeTitle(),
                observeText(),
            )
    }

    override fun shareText(note: String) {
        startActivity(Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, note)
        })
    }

    override fun share() {
        vm.shareNote(item?.title.toString(), item?.text.toString())
    }

    override fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun observeTitle(): String {
        var title = binding.frag2Title.text.toString()
        vm.noteTitle.observe(viewLifecycleOwner) {
            title = it
        }
        return title
    }

    private fun observeText(): String {
        var text = binding.frag2Text.text.toString()
        vm.noteText.observe(viewLifecycleOwner) {
            text = it
        }
        return text
    }

    private fun observeForShare() {
        vm.noteForShare.observe(viewLifecycleOwner) {
            if (it.isEmpty()) showMessage(getString(R.string.empty_note_alert))
            else shareText(it)
        }
    }

    companion object {
        fun newInstance(note: NoteModel)
                : InfoFragment = InfoFragment().apply {
            arguments = Bundle().apply { putParcelable(TITLE_KEY, note) }
        }

        fun newInstance() = InfoFragment()
    }
}




