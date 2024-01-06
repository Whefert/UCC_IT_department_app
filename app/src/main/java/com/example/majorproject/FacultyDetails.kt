package com.example.majorproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class FacultyDetails : AppCompatActivity() {

    var ivFacultyImage: ImageView? = null
    var tvFacultyName: TextView? = null
    var tvFacultyTitle: TextView? = null
    var tvPhoneNumber: TextView?= null
    var tvEmailAddress:TextView? = null
    var llPhoneNumber:LinearLayout? = null
    var llEmailAddress:LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculty_details)

        var myToolBar: Toolbar = findViewById(R.id.myToolbar)
        setSupportActionBar(myToolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title="Faculty Details"

        val listPosition = intent.getStringExtra("position")!!.toInt()
        val faculty = FacultyList.facultyList[listPosition]

        ivFacultyImage = findViewById<ImageView>(R.id.iv_facultyImage)
        tvFacultyName = findViewById<TextView>(R.id.tv_facultyName)
        tvFacultyTitle = findViewById<TextView>(R.id.tv_facultyTitle)
        tvPhoneNumber = findViewById(R.id.tv_phoneNumber)
        tvEmailAddress = findViewById(R.id.tv_emailAddress)
        llPhoneNumber = findViewById(R.id.ll_phoneNumber)
        llEmailAddress = findViewById(R.id.ll_email)

        ivFacultyImage?.setImageResource(faculty.image)
        tvFacultyName?.text = faculty.name
        tvFacultyTitle?.text = faculty.title
        tvPhoneNumber?.text= faculty.telephoneNumber
        tvEmailAddress?.text = faculty.email

        llPhoneNumber?.setOnClickListener {

            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + faculty.telephoneNumber))
            startActivity(intent)
        }

        llEmailAddress?.setOnClickListener {
                val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", faculty.email, null))
                intent.putExtra(Intent.EXTRA_EMAIL, faculty.email)
                startActivity(intent)
        }


        Toast.makeText(this,faculty.name,Toast.LENGTH_SHORT).show()
    }
}

