package com.example.assignment.model

/**
 * Created by rajeshkumar07 on 06-02-2020.
 */
data class Todo (
    val userId : Int = 0,
    val id: Int = 0,
    val title: String = "",
    val completed: Boolean = false
)