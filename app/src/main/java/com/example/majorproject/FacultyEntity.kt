package com.example.majorproject

import android.provider.ContactsContract.CommonDataKinds.Email

data class FacultyEntity(
    val id:Int,
    val name:String,
    val title: String,
    val image:Int,
    val telephoneNumber:String,
    val email: String,
)
