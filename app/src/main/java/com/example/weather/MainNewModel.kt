package com.example.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainNewModel: ViewModel() {
    val liveDataCurrent = MutableLiveData<String>() //прогноз на сегодняшний день
    val liveDataList = MutableLiveData<List<String>>() //прогноз на след дни
}