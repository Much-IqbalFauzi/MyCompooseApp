package com.example.myapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myapps.databinding.ActivityBindBinding

class BindAct : AppCompatActivity() {

    private lateinit var binding: ActivityBindBinding
    private lateinit var viewModel: BindActViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@BindAct, R.layout.activity_bind)
        viewModel = ViewModelProvider(this).get(BindActViewModel::class.java)
        binding.value.text = viewModel.getCurrent().toString()
        binding.counter.setOnClickListener {
            binding.value.text = viewModel.getUpdated(binding.input.text.toString().toInt()).toString()
        }
    }
}