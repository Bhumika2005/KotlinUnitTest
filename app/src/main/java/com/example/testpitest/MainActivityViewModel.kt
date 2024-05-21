package com.example.testpitest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class MainActivityViewModel: ViewModel() {

    private val _updateName = MutableLiveData<String>("Show Image")
    val updateName:LiveData<String> = _updateName

    private val _isImageVisible = MutableLiveData(false)
    val isImageVisible:LiveData<Boolean> = _isImageVisible

    fun buttonClick() {
        _isImageVisible.value = !_isImageVisible.value!!
        if (_isImageVisible.value!!) {
            _updateName.value = "Hide Image"
        } else {
            _updateName.value = "Show Image"
        }
    }
}