package com.example.myapplication.Fragment.NextTimetable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication.Fragment.BaseFragment
import com.example.myapplication.Fragment.Home.StudentHomeFragment
import com.example.myapplication.Fragment.Home.TeacherHomeFragment
import com.example.myapplication.Fragment.Login.LoginFragment
import com.example.myapplication.R

class NextTimetableFragment : BaseFragment() {

    var user = ""

    companion object {
        fun newInstance(user: String): NextTimetableFragment {
            val fragment = NextTimetableFragment()
            fragment.user = user
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        changeHeaderTitle("次の授業")
        switchBackFragment(this)
        val view = inflater.inflate(R.layout.next_timetable_fragment, container, false)
        val HomeButton = view.findViewById<Button>(R.id.home_button)
        HomeButton.setOnClickListener(onHomeClick)
        return view
    }

    private val onHomeClick = View.OnClickListener {
        when (user) {
            "student" -> {
                replaceFragment(StudentHomeFragment())
            }
            "teacher" -> {
                replaceFragment(TeacherHomeFragment())
            }
            else -> {
                replaceFragment(LoginFragment())
            }
        }
    }

}
