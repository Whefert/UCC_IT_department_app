package com.example.majorproject

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.majorproject.databinding.ActivityCoursesBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Courses : AppCompatActivity() {
    var binding: ActivityCoursesBinding?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCoursesBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val adapter = CoursesAdapter(CourseList.courseList,
            {
                    courseId -> getCourseDetails(courseId)
            }
        )
        binding?.rvCourses?.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
        binding?.rvCourses?.adapter = adapter

        var myToolBar: Toolbar = findViewById(R.id.myToolbar)
        setSupportActionBar(myToolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    fun getCourseDetails(position: String){
        val myIntent = Intent(this,CourseDetails::class.java)
        myIntent.putExtra("position", position)
        startActivity(myIntent)
    }

    override fun onDestroy(){
        super.onDestroy()
        binding =null
    }

}