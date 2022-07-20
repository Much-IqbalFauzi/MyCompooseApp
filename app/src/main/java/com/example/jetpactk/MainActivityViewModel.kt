package com.example.jetpactk

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(initial: Int): ViewModel() {
    private var total = MutableLiveData<Int>()
    val totalNum: LiveData<Int>
    get() = total

    init {
        total.value = initial
    }

    fun getValue(): String = total.toString()

    fun setValue(num: Int) {
        total.value = total.value?.plus(num)
    }

    fun setInc() {
        total.value = total.value?.plus(1)
    }
}