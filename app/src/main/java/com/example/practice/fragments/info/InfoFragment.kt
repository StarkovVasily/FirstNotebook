package com.example.practice.fragments.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practice.NoteModel
import com.example.practice.databinding.FragmentInfoBinding
import com.example.practice.presenter.MainPresenterImpl
import com.example.practice.view.MainActivity.Constant.TITLE_KEY
import com.example.practice.view.MainView

class InfoFragment : Fragment() {
    private lateinit var binding: FragmentInfoBinding
    private lateinit var presenter: MainPresenterImpl
    private var item: NoteModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            frag2Title.text = item?.title
            frag2Text.text = item?.text
            frag2Date.text = item?.date
        }
        toolbar()
    }

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

    private fun toolbar() = with(binding) {
        presenter = MainPresenterImpl(requireActivity() as? MainView)
        saveBtn.setOnClickListener {
            presenter.saveFromFrag2(frag2Title.text.toString(), frag2Text.text.toString())
        }
        shareBtn.setOnClickListener {
            presenter.shareFromFrag2(frag2Title.text.toString(), frag2Text.text.toString())
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = InfoFragment()
    }
}
