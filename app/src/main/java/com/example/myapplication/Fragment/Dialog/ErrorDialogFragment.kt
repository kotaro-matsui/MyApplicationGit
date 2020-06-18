package com.example.myapplication.Fragment.Dialog


import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.myapplication.Fragment.Lesson.LessonFragment

class ErrorDialogFragment: DialogFragment() {
    var alertTitle = ""
    var alertMessage = ""

    companion object {
        fun newInstance(alertTitle: String, alertMessage: String): ErrorDialogFragment {
            val dialogFragment = ErrorDialogFragment()
            dialogFragment.alertTitle = alertTitle
            dialogFragment.alertMessage = alertMessage
            return dialogFragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle(alertTitle)
            .setMessage(alertMessage)
            .setPositiveButton("OK") { dialog, id ->
                this.dismiss()
            }

        return builder.create()
    }

}