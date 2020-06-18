package com.example.myapplication.Fragment.Dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.ExpandableListView
import androidx.fragment.app.DialogFragment

class ConfirmationDialogFragment: DialogFragment() {
    var confirmationTitle = ""
    var confirmationMessage = ""
    var onClickOkListener : ConfirmationDialogListener? = null

    companion object {
        fun newInstance(confirmationTitle: String, confirmationMessage: String, listener: ConfirmationDialogListener): ConfirmationDialogFragment {
            val dialogFragment = ConfirmationDialogFragment()
            dialogFragment.confirmationTitle = confirmationTitle
            dialogFragment.confirmationMessage = confirmationMessage
            dialogFragment.onClickOkListener = listener
            return dialogFragment
        }
    }

    interface ConfirmationDialogListener {
        fun onClickOk()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        var isOkClick : Boolean = false
            builder.setTitle(confirmationTitle)
            .setMessage(confirmationMessage)
            .setPositiveButton("OK") { dialog, which ->
                this.dismiss()
                onClickOkListener!!.onClickOk()
    }
            .setNegativeButton("Cancel") { dialog, which ->
                this.dismiss()
            }

        return builder.create()
    }

}