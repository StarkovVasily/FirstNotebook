package com.example.practice.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.practice.databinding.ActivityEditBinding
import com.example.practice.presenter.PresenterEdit


class ViewEdit:AppCompatActivity(), ViewEditInterface {
    private lateinit var binding: ActivityEditBinding
    private lateinit var saveButton: Button
    private lateinit var title: EditText
    private lateinit var text: EditText
    private var presenter: PresenterEdit?=null

    override fun onCreate(savedInstaceState: Bundle?){
        super.onCreate(savedInstaceState)
        binding=ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        save()
        presenter=PresenterEdit(this)
    }
    override fun messaging(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }

    private fun initViews(){
        saveButton = binding.buttonSave
        title= binding.editTitle
        text=binding.editText
        presenter = PresenterEdit(this)
    }

    private fun save(){
        saveButton.setOnClickListener{
            presenter?.saveNote(title.text.toString(),text.text.toString())
    }
    }
    override fun onDestroy() {
        super.onDestroy()
        presenter?.view=null
    }
}