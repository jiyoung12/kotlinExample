package com.jiyoung.kotilnexample.ui.home

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "todd add ViewModel, liveData at NewFragment"
    }
    val text: LiveData<String> = _text
}