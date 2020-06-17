package com.example.myapplication.Fragment.Dialog


import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class EmptyErrorDialogFragment: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("入力エラー①")
            .setMessage("空欄があります")
            .setPositiveButton("OK") { dialog, id ->
                println("dialog:$dialog which:$id")
            }

        return builder.create()
    }

}