package com.example.myapplication.Fragment.Dialog


import android.R
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.view.WindowManager.*
import androidx.fragment.app.DialogFragment

class MenuDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog: Dialog = Dialog(context!!)
        val dw = dialog.window
        dw?.let {
            it.requestFeature(Window.FEATURE_NO_TITLE)
            it.setFlags(
                LayoutParams.FLAG_FULLSCREEN,
                LayoutParams.FLAG_LAYOUT_IN_SCREEN
            )
            it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));
        }
        /*dialog.setContentView(R.layout.menu_dialog_fragment)*/
            //クリック時実行したい処理を記述
            //動作デモではここでChromeCustomTabを開いています。
        return dialog
    }
}
