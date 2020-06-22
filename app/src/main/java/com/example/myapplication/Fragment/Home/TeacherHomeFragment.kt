package com.example.myapplication.Fragment.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.Fragment.BaseFragment
import com.example.myapplication.Fragment.Lesson.LessonFragment
import com.example.myapplication.Fragment.Login.LoginFragment
import com.example.myapplication.Fragment.NextTimetable.NextTimetableFragment
import com.example.myapplication.Model.ListObject
import com.example.myapplication.R
import io.realm.Realm
import kotlinx.android.synthetic.*

class TeacherHomeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.teacher_home_fragment, container, false)
        var logoutButton = view.findViewById<Button>(R.id.logout)
        logoutButton.setOnClickListener(onLogoutClick)
        var firstLessonButton = view.findViewById<Button>(R.id.first_lesson_button)
        firstLessonButton.setOnClickListener(onLessonClick)
        var secondLessonButton = view.findViewById<Button>(R.id.second_lesson_button)
        secondLessonButton.setOnClickListener(onLessonClick)
        var thirdLessonButton = view.findViewById<Button>(R.id.third_lesson_button)
        thirdLessonButton.setOnClickListener(onLessonClick)
        var fourthLessonButton = view.findViewById<Button>(R.id.fourth_lesson_button)
        fourthLessonButton.setOnClickListener(onLessonClick)
        var nextTimetableButton= view.findViewById<Button>(R.id.next_timetable_button)
        nextTimetableButton.setOnClickListener(onNextTimetableClick)

        return view
    }

    val onLogoutClick = View.OnClickListener {
        replaceFragment(LoginFragment())
    }

    val onLessonClick = View.OnClickListener {

        var lessonName = ""
        var lessonNum = 1

        when(it.id){
            R.id.first_lesson_button -> {
                lessonName = "１コマ目の授業"
                lessonNum = 1
            }
            R.id.second_lesson_button -> {
                lessonName = "２コマ目の授業"
                lessonNum = 2
            }
            R.id.third_lesson_button -> {
                lessonName = "３コマ目の授業"
                lessonNum = 3
            }
            R.id.fourth_lesson_button -> {
                lessonName = "４コマ目の授業"
                lessonNum = 4
            }
            else -> {
                lessonName = "Error"
            }
        }

        replaceFragment(LessonFragment.newInstance(lessonName, lessonNum))

    }

    val onNextTimetableClick = View.OnClickListener {
        var user = "teacher"
        replaceFragment(NextTimetableFragment.newInstance(user))
    }
}