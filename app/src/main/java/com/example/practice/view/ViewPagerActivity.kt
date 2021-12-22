package com.example.practice.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.practice.R
import com.example.practice.databinding.ActivityViewPagerBinding
import com.example.practice.fragments.info.Dialog
import com.example.practice.fragments.info.InfoFragment
import com.example.practice.model.NoteDatabase
import com.example.practice.presenter.*
import com.example.practice.viewPager.ViewPagerAdapter

class ViewPagerActivity : AppCompatActivity(), ViewPagerView, Save {

    private lateinit var binding: ActivityViewPagerBinding
    private lateinit var presenter: MainPresenter
    override var currentFragment: InfoFragment? = null
    private var adapter: ViewPagerAdapter = ViewPagerAdapter(this, emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MainPresenterImpl(NoteDatabase.getInstance(this))
        adapter = ViewPagerAdapter(this, presenter.noteData())
        val id = intent.getLongExtra(EXTRA_KEY, 0)
        initViewPager(id.toInt() - 1)
        toolbarActions()
    }

    private fun initViewPager(id: Int) = with(binding) {
        viewPager.adapter = adapter
        viewPager.setCurrentItem(id, false)
    }

    private fun toolbarActions() = with(binding) {
        saveBtnPager.setOnClickListener {
            Dialog(R.string.fragment_dialog_message).show(
                supportFragmentManager, INFO_TAG
            )
        }
        backBtnPager.setOnClickListener {
            onBackPressed()
        }
        shareBtnPager.setOnClickListener {
            currentFragment?.share()
        }
    }

    override fun showMessage() {
        Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show()
    }

    override fun save() {
        currentFragment?.save()
    }

    companion object Constant {
        const val EXTRA_KEY = "key"
        const val INFO_TAG = "info"
    }
}




