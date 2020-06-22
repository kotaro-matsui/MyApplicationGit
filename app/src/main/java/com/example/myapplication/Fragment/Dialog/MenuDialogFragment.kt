package com.example.myapplication.Fragment.Dialog


import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager.LayoutParams
import androidx.fragment.app.DialogFragment

class MenuDialogFragment(private val gravity: Int,
                         private val verticalMargin: Float,
                         private val horizontalMargin: Float) : DialogFragment() {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(activity!!)
        dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        dialog.window!!.setFlags(
            LayoutParams.FLAG_FULLSCREEN,
            LayoutParams.FLAG_LAYOUT_IN_SCREEN
        )
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.setContentView(com.example.myapplication.R.layout.menu_dialog_fragment)
        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adjustDialogPosition()
    }

    private fun adjustDialogPosition() {
        dialog?.window?.attributes?.also { attributes ->
            attributes.gravity = this.gravity
            attributes.verticalMargin = this.verticalMargin
            attributes.horizontalMargin = this.horizontalMargin
        }
    }
}
