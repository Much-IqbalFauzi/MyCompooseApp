package com.example.jetpactk

import androidx.lifecycle.ViewModel

class MainActivityViewModel(initial: Int): ViewModel() {
    private var count = 0

    init {
        count = initial
    }

    fun getValue(): String = count.toString()

    fun setValue(num: Int) {
        count += num
    }
}