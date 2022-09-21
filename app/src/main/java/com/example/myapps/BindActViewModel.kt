package com.example.myapps

import androidx.lifecycle.ViewModel

class BindActViewModel : ViewModel(){
    private var count = 0

    fun getCurrent(): Int {
        return count
    }

    fun getUpdated(number: Int){
        count += number
    }
}