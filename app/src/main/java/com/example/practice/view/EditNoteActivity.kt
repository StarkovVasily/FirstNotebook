package com.example.practice.view


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practice.databinding.ActivityEditBinding
import com.example.practice.presenter.PresenterEditImpl
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import com.example.practice.R
import com.example.practice.model.NoteDatabase


class EditNoteActivity : AppCompatActivity(), EditNote {
    private lateinit var binding: ActivityEditBinding
    private var presenter: PresenterEditImpl? = null

    override fun onCreate(savedInstaceState: Bundle?) {
        super.onCreate(savedInstaceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        toolbarAction()
        if (savedInstaceState != null) {
            showDialog(
                binding.editTitle.text.toString(),
                binding.editText.text.toString()
            )
        }
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
            showDialog(editTitle.text.toString(), editText.text.toString())
        }
        shareBtn.setOnClickListener {
            presenter?.shareNote(editTitle.text.toString(), editText.text.toString())
        }
        backBtn.setOnClickListener {
            onBackPressed()
        }
    }

    override fun showDialog(title: String, text: String) {
        AlertDialog.Builder(this)
            .setMessage(R.string.dialog_message)
            .setPositiveButton(
                R.string.positive
            ) { _, _ ->
                presenter?.saveNote(title, text)
            }.setNegativeButton(R.string.negative) { dialog, _ ->
                dialog.dismiss()
            }
            .setCancelable(true)
            .create().show()
    }

    private fun initViews() {
        presenter = PresenterEditImpl(this, NoteDatabase.getInstance(this))
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.view = null
    }
}


