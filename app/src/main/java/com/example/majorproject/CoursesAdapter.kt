package com.example.majorproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.majorproject.databinding.ActivityCourseRowBinding


class CoursesAdapter (private val courseList: List<CourseEntity>,
                      private val getDetails: (courseId:String)-> Unit,
): RecyclerView.Adapter<CoursesAdapter.CourseViewHolder>(){

    inner class CourseViewHolder(private val itemBinding: ActivityCourseRowBinding)
        : RecyclerView.ViewHolder(itemBinding.root){
        val llCourse = itemBinding.llCourse
        fun bindItem(course: CourseEntity){
            itemBinding.tvCourseName.text = course.name
            itemBinding.tvCourseNumber.text = course.code
            itemBinding.tvCourseDescription.text = course.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        return CourseViewHolder(ActivityCourseRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courseList[position]
        holder.bindItem(course)
        holder.llCourse.setOnClickListener {
            getDetails.invoke(position.toString())
        }

    }

}