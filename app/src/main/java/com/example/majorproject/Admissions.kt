package com.example.majorproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class Admissions : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admissions)

        var myToolBar: Toolbar = findViewById(R.id.myToolbar)
        setSupportActionBar(myToolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var tvAdmissionsPageLink: TextView = findViewById(R.id.tv_admissionsPageLink)
        tvAdmissionsPageLink.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://ucc.edu.jm/apply/")
            startActivity(intent)
        }


    }
}