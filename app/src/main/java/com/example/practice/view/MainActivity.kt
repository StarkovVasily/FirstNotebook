package com.example.practice.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.practice.NoteModel
import com.example.practice.R
import com.example.practice.databinding.ActivityMainBinding
import com.example.practice.fragments.info.InfoFragment
import com.example.practice.fragments.list.ListFragment


class MainActivity : AppCompatActivity(), MainView.Fragments {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolbar()
        openFrag(R.id.fragContainer, ListFragment.newInstance())
    }

    private fun toolbar() = with(binding) {
        backBtnMain.setOnClickListener {
            onBackPressed()
        }
        goToAbout.setOnClickListener {
            startActivity(Intent(this@MainActivity, AboutActivity::class.java))
        }
    }

    override fun openFrag(id: Int, f: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(id, f)
            .commit()
    }

    override fun openInfoFragment(note: NoteModel) {
        val bundle = Bundle().apply {
            putParcelable(TITLE_KEY, note)
        }
        val fragManage = InfoFragment.newInstance()
        fragManage.arguments = bundle
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.frag2Container, fragManage)
            .commit()
    }

    override fun shareFromFrag2(note: String) {
        startActivity(Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, note)
        })
    }

    override fun messagingFromFrag2(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object Constant {
        const val TITLE_KEY = "title"
    }
}