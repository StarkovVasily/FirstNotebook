package com.example.practice.view

import android.os.Bundle

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practice.R
import com.example.practice.databinding.ActivityEditBinding
import com.example.practice.presenter.PresenterEditImpl
import android.content.Intent
import com.example.practice.MainActivity


class ViewEditImpl : AppCompatActivity(), ViewEdit {
    private lateinit var binding: ActivityEditBinding
    private var presenter: PresenterEditImpl? = null

    override fun onCreate(savedInstaceState: Bundle?) {
        super.onCreate(savedInstaceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        toolbarAction()
    }

    override fun messaging(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun share(note: String) {
        startActivity(Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, note)
        })
    }

    override fun toMain(title: String) = with(binding) {
        startActivity(
            Intent(this@ViewEditImpl, MainActivity::class.java)
                .putExtra("title", title)
        )
    }

    private fun toolbarAction() = with(binding) {
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.save_btn -> {
                    presenter?.saveNote(editTitle.text.toString(), editText.text.toString())
                    presenter?.titleToMain(editTitle.text.toString(), editText.text.toString())
                    true
                }
                R.id.share_btn -> {
                    presenter?.shareNote(editTitle.text.toString(), editText.text.toString())
                    true
                }
                else -> false
            }
        }
    }

    private fun initViews() {
        presenter = PresenterEditImpl(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.view = null
    }
}


