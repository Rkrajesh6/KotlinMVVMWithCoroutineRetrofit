package com.example.assignment.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.assignment.model.Todo
import com.example.assignment.repository.MainRepository
import kotlinx.coroutines.launch

/**
 * Created by rajeshkumar07 on 06-02-2020.
 */
class MainViewModel(application: Application) : AndroidViewModel(application){

    private val mainRepository = MainRepository()

    val successfulLiveData = mainRepository.successLiveData
    val failureLiveData = mainRepository.failureLiveData
    private var mutableList = MutableLiveData<List<Todo>>().apply { value = emptyList() }
    val listData: LiveData<List<Todo>> = mutableList
    fun getTodoList(){
        viewModelScope.launch { mainRepository.getTodoList()}
    }
}