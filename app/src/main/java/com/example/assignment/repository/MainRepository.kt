package com.example.assignment.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.assignment.model.Todo
import com.example.assignment.network.RetrofitService
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by rajeshkumar07 on 06-02-2020.
 */
class MainRepository {
    private val retrofitService = RetrofitService.create()
    val successLiveData = MutableLiveData<List<Todo>>()
    val failureLiveData = MutableLiveData<Boolean>()

    companion object {
        val TAG = MainRepository::class.java.simpleName
    }

    /**
     * Created by : rajeshkumar07
     * Created Date/Time : 06-02-2020 17:12
     * Description : this fun is suspend fun means it will execute in different thread
     */
    suspend fun getTodoList() {
        try {
            val response = retrofitService?.getTodo()

            if (response!!.isSuccessful) {
                Log.d(TAG, "SUCCESS")
                Log.d(TAG, "${response.body()}")
                successLiveData.postValue(response.body())
            } else {
                Log.d(TAG, "FAILURE")
                Log.d(TAG, "${response.body()}")
                failureLiveData.postValue(true)
            }
        } catch (e: UnknownHostException) {
            //this exception occurs when there is no internet connection or host is not available
            //so inform user that something went wrong
            failureLiveData.postValue(true)
        } catch (e: SocketTimeoutException) {
            //this exception occurs when time out will happen
            //so inform user that something went wrong
            failureLiveData.postValue(true)
        } catch (exception: Exception) {
            //this is generic exception handling
            //so inform user that something went wrong
            failureLiveData.postValue(true)
        }
    }
}