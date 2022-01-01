package com.example.practice.fragments.info

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.practice.R
import com.example.practice.view.Save

class Dialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            AlertDialog.Builder(it).apply {
                setMessage(R.string.dialog_message)
                setNegativeButton(R.string.negative, null)
                setPositiveButton(R.string.positive) { _, _ ->
                    (activity as? Save)?.save()
                }
            }.create()
        } ?: throw  IllegalStateException("Exception")
    }
}
