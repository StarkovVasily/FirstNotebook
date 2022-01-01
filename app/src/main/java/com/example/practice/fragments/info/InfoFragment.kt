package com.example.practice.fragments.info


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.practice.NoteModel
import com.example.practice.R
import com.example.practice.databinding.FragmentInfoBinding
import com.example.practice.model.NoteDatabase
import com.example.practice.view.MainActivity.Constant.TITLE_KEY
import com.example.practice.view.Save


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
        presenter = InfoFragPresenterImpl(this, NoteDatabase.getInstance(requireContext()))
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            frag2Title.setText(item?.title)
            frag2Text.setText(item?.text)
            frag2Date.text = item?.date
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as? Save)?.currentFragment = this
    }

    override fun save() = with(binding) {
        if (frag2Title.text.isEmpty() && frag2Text.text.isEmpty())
            Toast.makeText(requireContext(), R.string.empty_note_alert, Toast.LENGTH_SHORT).show()
        else
            presenter.save(
                frag2Title.text.toString(),
                frag2Text.text.toString(),
                item?.id?.toInt()
            )
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

        fun newInstance() = InfoFragment()
    }
}


