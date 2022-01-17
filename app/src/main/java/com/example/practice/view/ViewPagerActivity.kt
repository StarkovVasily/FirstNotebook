package com.example.practice.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.practice.NoteModel
import com.example.practice.R
import com.example.practice.databinding.ActivityViewPagerBinding
import com.example.practice.fragments.info.Dialog
import com.example.practice.fragments.info.InfoFragment
import com.example.practice.model.NoteRepositoryImpl
import com.example.practice.viewModel.PagerViewModel
import com.example.practice.viewModel.PagerViewModelFactory
import com.example.practice.viewPager.ViewPagerAdapter

class ViewPagerActivity : AppCompatActivity(), ViewPagerView, Save {

    private lateinit var binding: ActivityViewPagerBinding
    override var currentFragment: InfoFragment? = null
    private var adapter: ViewPagerAdapter = ViewPagerAdapter(this, emptyList())
    private lateinit var vm: PagerViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vm = ViewModelProvider(
            this,
            PagerViewModelFactory(NoteRepositoryImpl(this))
        ).get(PagerViewModel::class.java)
        adapter = ViewPagerAdapter(this, vm.noteData())
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
            Dialog().show(
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




