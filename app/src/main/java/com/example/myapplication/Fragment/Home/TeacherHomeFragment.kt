package com.example.myapplication.Fragment.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.myapplication.Fragment.BaseFragment
import com.example.myapplication.Fragment.Lesson.LessonFragment
import com.example.myapplication.Fragment.NextTimetable.NextTimetableFragment
import com.example.myapplication.R

class TeacherHomeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        changeHeaderTitle("HOME")
        switchBackFragment(this)
        switchMenuFragment(this)
        val view = inflater.inflate(R.layout.teacher_home_fragment, container, false)
        val firstLessonButton = view.findViewById<Button>(R.id.first_lesson_button)
        firstLessonButton.setOnClickListener(onLessonClick)
        val secondLessonButton = view.findViewById<Button>(R.id.second_lesson_button)
        secondLessonButton.setOnClickListener(onLessonClick)
        val thirdLessonButton = view.findViewById<Button>(R.id.third_lesson_button)
        thirdLessonButton.setOnClickListener(onLessonClick)
        val fourthLessonButton = view.findViewById<Button>(R.id.fourth_lesson_button)
        fourthLessonButton.setOnClickListener(onLessonClick)
        val nextTimetableButton= view.findViewById<Button>(R.id.next_timetable_button)
        nextTimetableButton.setOnClickListener(onNextTimetableClick)

        return view
    }

    private val onLessonClick = View.OnClickListener {

        val lessonName: String
        var lessonNum = 0

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

    private val onNextTimetableClick = View.OnClickListener {
        val user = "teacher"
        replaceFragment(NextTimetableFragment.newInstance(user))
    }
}