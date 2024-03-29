package com.example.g15_comp304sec001_lab4_ex02.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.g15_comp304sec001_lab4_ex02.data.Program
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProgramsViewModel(private val application: Application) : AndroidViewModel(application) {
    /*
    private val _programs = MutableLiveData<List<Program>>()
    val programs: LiveData<List<Program>> = _programs

    init {
        _programs.value = loadPrograms()
    }

     */

    fun loadPrograms(): List<Program> {
        val jsonString = application.assets.open("programs.json").bufferedReader().use { it.readText() }
        val listType = object : TypeToken<List<Program>>() {}.type
        return Gson().fromJson(jsonString, listType)
    }
}
