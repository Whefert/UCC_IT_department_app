package com.example.majorproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class CourseDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_details)

        var myToolBar: Toolbar = findViewById(R.id.myToolbar)
        setSupportActionBar(myToolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title="Course Details"

        val position = intent.getStringExtra("position")
        var course: CourseEntity = CourseList.courseList[position!!.toInt()]

        val tvCourseCodeAndName: TextView = findViewById(R.id.tv_courseCodeAndName)
        val tvCourseDescription: TextView = findViewById(R.id.tv_courseDescription)
        val tvPrerequisiteOne: TextView = findViewById(R.id.tv_prerequisite1)
        val tvPrerequisiteTwo: TextView = findViewById(R.id.tv_prerequisite2)
        val tvCredits: TextView = findViewById(R.id.tv_credits)

        tvCourseCodeAndName.text="${course.code}: ${course.name}"
        tvCourseDescription.text=course.description
        tvPrerequisiteOne.text = "1. ${course.prerequisiteOne}"
        tvPrerequisiteTwo.text ="2. ${course.prerequisiteTwo}"
        tvCredits.text = "Credits: ${course.credits}"
    }
}