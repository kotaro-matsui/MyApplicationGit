package com.example.myapplication.Fragment.InitialSetting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication.Fragment.BaseFragment
import com.example.myapplication.Fragment.Login.LoginFragment
import com.example.myapplication.R
import kotlinx.android.synthetic.main.login_fragment.view.*

class InitialSettingFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.initial_setting_fragment, container, false)
        var loginButton = view.findViewById<Button>(R.id.login_button)
        loginButton.setOnClickListener(onLoginClick)
        return view
    }

    val onLoginClick = View.OnClickListener {
        replaceFragment(LoginFragment())
    }
}