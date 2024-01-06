package com.example.majorproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.majorproject.databinding.ActivityFacultyStaffDirectoryBinding

class FacultyDirectory : AppCompatActivity() {

    var binding: ActivityFacultyStaffDirectoryBinding?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//
        binding = ActivityFacultyStaffDirectoryBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val adapter = FacultyAdapter(FacultyList.facultyList,
            {
                    facultyId -> getFacultyDetails(facultyId)
            }
        )
        binding?.rvFaculty?.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        binding?.rvFaculty?.adapter = adapter

        var myToolBar: Toolbar = findViewById(R.id.myToolbar)
        setSupportActionBar(myToolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun getFacultyDetails(position: Int){
        val myIntent = Intent(this,FacultyDetails::class.java)
        myIntent.putExtra("position", position.toString())
        startActivity(myIntent)
    }

       override fun onDestroy(){
           super.onDestroy()
           binding =null
       }

}