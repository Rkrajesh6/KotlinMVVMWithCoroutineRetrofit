package com.example.assignment.network

import com.example.assignment.model.Todo
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by rajeshkumar07 on 06-02-2020.
 */
interface Api {
    @GET("/todos")
    suspend fun getTodo(): Response<List<Todo>>
}