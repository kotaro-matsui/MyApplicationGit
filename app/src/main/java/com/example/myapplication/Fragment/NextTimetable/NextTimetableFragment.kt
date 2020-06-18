package com.example.myapplication.Fragment.NextTimetable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication.Fragment.BaseFragment
import com.example.myapplication.Fragment.Home.StudentHomeFragment
import com.example.myapplication.Fragment.Home.TeacherHomeFragment
import com.example.myapplication.Fragment.Lesson.LessonFragment
import com.example.myapplication.Fragment.Login.LoginFragment
import com.example.myapplication.Model.BaseModel
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
        //
        val view = inflater.inflate(R.layout.next_timetable_fragment, container, false)
        var HomeButton = view.findViewById<Button>(R.id.home_button)
        HomeButton.setOnClickListener(onHomeClick)
        return view
    }

    val onHomeClick = View.OnClickListener {
        if (user == "student") {
            transitionPage(StudentHomeFragment())
            changeTitle("HOME")
        } else if (user == "teacher") {
            transitionPage(TeacherHomeFragment())
            changeTitle("HOME")
        } else {
            transitionPage(LoginFragment())
            changeTitle("ログイン")
        }
    }

}
