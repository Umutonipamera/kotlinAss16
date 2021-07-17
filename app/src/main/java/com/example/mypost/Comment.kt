package com.example.mypost

import android.provider.ContactsContract

data class Comment(
    var name:String,
    var email:String,
    var body:String,
    var id:Int,
)
