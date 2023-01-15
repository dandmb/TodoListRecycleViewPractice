package com.example.prepafour

import java.util.UUID

data class Note(
    val title:String,
    val text:String,
    val id:String=UUID.randomUUID().toString()

)
