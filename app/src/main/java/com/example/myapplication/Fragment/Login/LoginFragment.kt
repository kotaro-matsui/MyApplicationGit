package com.example.myapplication.Fragment.Login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication.Fragment.BaseFragment
import com.example.myapplication.Fragment.Home.HomeFragment
import com.example.myapplication.R


class LoginFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //
        val view = inflater.inflate(R.layout.login_fragment, container, false)
        var loginButton = view.findViewById<Button>(R.id.login_button)
        loginButton.setOnClickListener(onLoginClick)
        return view
    }

    val onLoginClick = View.OnClickListener {
        replaceFragment(HomeFragment())
        
    }
}