package com.example.practice.fragments.info

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import com.example.practice.NoteModel
import com.example.practice.R
import com.example.practice.databinding.FragmentInfoBinding
import com.example.practice.model.NoteDatabase
import com.example.practice.view.MainActivity.Constant.TITLE_KEY
import com.example.practice.view.ViewPagerActivity


class InfoFragment : Fragment(), Info.View {
    private lateinit var binding: FragmentInfoBinding
    private var item: NoteModel? = null
    private lateinit var presenter: InfoFragPresenterImpl

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (arguments != null && arguments?.containsKey(TITLE_KEY) == true) {
            item = arguments?.getParcelable(TITLE_KEY) as? NoteModel?
        }
        presenter = InfoFragPresenterImpl(this, item, NoteDatabase.getInstance(requireContext()))
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            frag2Title.setText(item?.title)
            frag2Text.setText(item?.text)
            frag2Date.text = item?.date
            frag2Title.addTextChangedListener { presenter.updateTitle(it?.toString().orEmpty()) }
            frag2Text.addTextChangedListener { presenter.updateText(it?.toString().orEmpty()) }
        }
    }


    override fun onResume() {
        super.onResume()
        (activity as? ViewPagerActivity)?.currentFragment = this
    }

    override fun save() {
        AlertDialog.Builder(requireContext())
            .setMessage(R.string.fragment_dialog_message)
            .setPositiveButton(
                R.string.positive
            ) { _, _ ->
                presenter.saveNote()
            }.setNegativeButton(R.string.negative) { dialog, _ ->
                dialog.dismiss()
            }
            .setCancelable(true)
            .create().show()
    }

    override fun shareText(note: String) {
        startActivity(Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, note)
        })
    }

    override fun share() {
        presenter.shareNote(item?.title.toString(), item?.text.toString())
    }

    override fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun newInstance(note: NoteModel)
                : InfoFragment = InfoFragment().apply {
            arguments = Bundle().apply { putParcelable(TITLE_KEY, note) }
        }
    }
}


