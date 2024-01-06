package com.example.majorproject

import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getCourses(CourseList.courseList)

        val fabEmail: FloatingActionButton = findViewById(R.id.fab_email)
        fabEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","ithod@ucc.edu.jm" , null))
            startActivity(intent)
        }
         val tvFacultyStaff: TextView = findViewById<TextView>(R.id.tv_facultyStaff)
        tvFacultyStaff.setOnClickListener{
            val intent =  Intent(this,FacultyDirectory::class.java)
            startActivity(intent)
        }

        val tvAdmissions: TextView = findViewById<TextView>(R.id.tv_admissions)
        tvAdmissions.setOnClickListener{
            val intent =  Intent(this,Admissions::class.java)
            startActivity(intent)
        }


        val tvCourses: TextView = findViewById<TextView>(R.id.tv_courses)
        tvCourses.setOnClickListener{
            val intent =  Intent(this,Courses::class.java)
            startActivity(intent)
        }

        val ivInstagram: ImageView = findViewById<ImageView>(R.id.ivInstagram)
        ivInstagram.setOnClickListener{
            val intent =  Intent(this,Social::class.java)
            intent.putExtra("platform", "Instagram")
            startActivity(intent)
        }

        val ivTwitter: ImageView = findViewById<ImageView>(R.id.ivTwitter)
        ivTwitter.setOnClickListener{
            val intent =  Intent(this,Social::class.java)
            intent.putExtra("platform", "Twitter")
            startActivity(intent)
        }

        val ivFacebook: ImageView = findViewById<ImageView>(R.id.ivFacebook)
        ivFacebook.setOnClickListener{
            val intent =  Intent(this,Social::class.java)
            intent.putExtra("platform", "Facebook")
            startActivity(intent)
        }


    }

}

fun getCourses(courseList: ArrayList<CourseEntity>){
    val db = Firebase.firestore
    db.collection("courses")
        .get()
        .addOnSuccessListener { result ->
            courseList.clear()
            for (data in result) {
                val course:CourseEntity? = data.toObject(CourseEntity::class.java)
                if(course!= null){
                    courseList.add(course)
                }
                Log.d(ContentValues.TAG, "Document found${data.id} => ${data.data}")
            }
        }
        .addOnFailureListener { exception ->
            Log.w(ContentValues.TAG, "Error getting documents.", exception)
        }
}