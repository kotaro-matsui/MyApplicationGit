package com.example.myapplication.Fragment.Dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class InformationDialogFragment: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("教室の先生に相談しましょう")
            .setMessage("総合連絡先：XXX-XXXX-XXX")
            .setPositiveButton("OK") { dialog, id ->
                println("dialog:$dialog which:$id")
            }

        return builder.create()
    }

}