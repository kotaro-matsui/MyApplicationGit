package com.example.myapplication.Fragment.InitialSetting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication.Fragment.BaseFragment
import com.example.myapplication.Fragment.Dialog.ConfirmationDialogFragment
import com.example.myapplication.Fragment.Dialog.ErrorDialogFragment
import com.example.myapplication.Fragment.Login.LoginFragment
import com.example.myapplication.R
import kotlinx.android.synthetic.main.initial_setting_fragment.*
import kotlinx.android.synthetic.main.login_fragment.user_id

class InitialSettingFragment : BaseFragment() , ConfirmationDialogFragment.ConfirmationDialogListener{

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        changeHeaderTitle("初回設定")
        switchBackButton(this)
        val view = inflater.inflate(R.layout.initial_setting_fragment, container, false)
        val entryButton = view.findViewById<Button>(R.id.entry_button)
       entryButton.setOnClickListener(onEntryClick)

        return view
    }

    private val onEntryClick = View.OnClickListener {
        val entryConfirmation = ConfirmationDialogFragment.newInstance("登録", "この情報で登録しますか？", this)
        entryConfirmation.show(activity!!.supportFragmentManager, "entry")
    }

    override fun onClickOk() {
        if (user_id.text.toString() == "" || phone_number.text.toString() == "" || new_password.text.toString() == "" || re_password.text.toString() == "") {
            val emptyError = ErrorDialogFragment.newInstance("入力エラー", "入力されていない項目が存在します")
            emptyError.show(activity!!.supportFragmentManager, "empty")
        } else if (new_password.text.toString() != re_password.text.toString()) {
            val mistakeError = ErrorDialogFragment.newInstance("入力エラー", "新しいパスワードと確認用のパスワードが異なっています")
            mistakeError.show(activity!!.supportFragmentManager, "mistake")
        } else {
            replaceFragment(LoginFragment())
        }
    }
}