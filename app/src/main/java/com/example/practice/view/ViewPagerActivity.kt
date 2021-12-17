package com.example.practice.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.practice.R
import com.example.practice.databinding.ActivityViewPagerBinding
import com.example.practice.model.NoteDatabase
import com.example.practice.presenter.*
import com.example.practice.viewPager.ViewPagerAdapter

class ViewPagerActivity : AppCompatActivity(), ViewPagerView {

    private lateinit var binding: ActivityViewPagerBinding
    private lateinit var presenter: VPagerPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = VPagerPresenterImpl(this, NoteDatabase.getInstance(this))
        val id = intent.getLongExtra(EXTRA_KEY, 0)
        initViewPager(id.toInt() - 1)
    }

    private fun initViewPager(id: Int) = with(binding) {
        val adapter = ViewPagerAdapter(presenter.noteData())
        viewPager.adapter = adapter
        viewPager.setCurrentItem(id, false)
        saveBtnPager.setOnClickListener {
            presenter.saveFromPager(adapter.getItem(viewPager.currentItem))
        }
        backBtnPager.setOnClickListener {
            onBackPressed()
        }
    }

    override fun showMessage() {
        Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show()
    }

    companion object Constant {
        const val EXTRA_KEY = "key"
    }
}




