package com.example.majorproject
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.majorproject.databinding.ActivityFacultyRowBinding


class FacultyAdapter (private val facultyList: List<FacultyEntity>,
                      private val getDetails: (id:Int)-> Unit,
                     ):RecyclerView.Adapter<FacultyAdapter.FacultyViewHolder>(){

    inner class FacultyViewHolder(private val itemBinding:ActivityFacultyRowBinding)
        :RecyclerView.ViewHolder(itemBinding.root){
        val llFaculty = itemBinding.llFaculty
        fun bindItem(faculty: FacultyEntity){
            itemBinding.ivFacultyPhoto.setImageResource(faculty.image)
            itemBinding.tvFacultyName.text = faculty.name
            itemBinding.tvFacultyTitle.text = faculty.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacultyViewHolder {
        return FacultyViewHolder(ActivityFacultyRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return facultyList.size
    }

    override fun onBindViewHolder(holder: FacultyViewHolder, position: Int) {
        val faculty = facultyList[position]
        holder.bindItem(faculty)
        holder.llFaculty.setOnClickListener {
            getDetails.invoke(position)
        }

   }



}