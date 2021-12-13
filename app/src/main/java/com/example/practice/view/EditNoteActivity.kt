package com.example.practice.view


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practice.databinding.ActivityEditBinding
import com.example.practice.presenter.PresenterEditImpl
import android.content.Intent


class EditNoteActivity : AppCompatActivity(), EditNote {
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

    private fun toolbarAction() = with(binding) {
        saveBtn.setOnClickListener {
            presenter?.saveNote(editTitle.text.toString(), editText.text.toString())
        }
        shareBtn.setOnClickListener {
            presenter?.shareNote(editTitle.text.toString(), editText.text.toString())
        }
        backBtn.setOnClickListener {
            onBackPressed()
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


