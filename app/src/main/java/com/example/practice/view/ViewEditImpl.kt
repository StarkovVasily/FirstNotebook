package com.example.practice.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practice.databinding.ActivityEditBinding
import com.example.practice.presenter.PresenterEditImpl


class ViewEditImpl : AppCompatActivity(), ViewEdit {
    private lateinit var binding: ActivityEditBinding
    private var presenter: PresenterEditImpl? = null

    override fun onCreate(savedInstaceState: Bundle?) {
        super.onCreate(savedInstaceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        save()
    }

    override fun messaging(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun save() = with(binding) {
        buttonSave.setOnClickListener {
            presenter?.saveNote(editTitle.text.toString(), editText.text.toString())
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