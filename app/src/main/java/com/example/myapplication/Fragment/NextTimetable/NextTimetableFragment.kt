package com.example.myapplication.Fragment.NextTimetable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import com.example.myapplication.Adapter.TimetableAdapter
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
        switchBackButton(this)
        switchMenuButton(this)
        val view = inflater.inflate(R.layout.next_timetable_fragment, container, false)
        val HomeButton = view.findViewById<Button>(R.id.home_button)
        HomeButton.setOnClickListener(onHomeClick)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //リストビューに表示するリストを手動で作成
        val times = listOf("1時間目 10：00 ～ 10：45", "2時間目 11：00 ～ 11：45", "3時間目 12：00 ～ 12：45", "4時間目 13：00 ～ 13：45", "5時間目 14：00 ～ 14：45",
            "6時間目 15：00 ～ 15：45", "7時間目 16：00 ～ 16：45", "8時間目 17：00 ～ 17：45", "9時間目 18：00 ～ 18：45")
        val booths = listOf("G22", "A1", "G22", "A1", "G22", "A1", "G22", "A1", "G22")
        val subjects = listOf("日本史", "国語", "日本史", "国語", "日本史", "国語", "日本史", "国語", "日本史")
        val teachers = listOf("担当：キング", "担当：板金", "担当：キング", "担当：板金", "担当：キング", "担当：板金", "担当：キング", "担当：板金", "担当：キング")

        val listView = view.findViewById<ListView>(R.id.next_timetable)

        listView.adapter = TimetableAdapter(activity!!.applicationContext, times, booths, subjects, teachers)
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
