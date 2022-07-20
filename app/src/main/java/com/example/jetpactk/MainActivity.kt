package com.example.jetpactk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.jetpactk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        viewModelFactory = MainActivityViewModelFactory(0)
        viewModel = ViewModelProvider(this@MainActivity, viewModelFactory).get(MainActivityViewModel::class.java)
        binding.value.text = viewModel.getValue()
        binding.button.setOnClickListener {
            viewModel.setValue(binding.input.text.toString().toInt()).toString()
            binding.value.text = viewModel.getValue()
        }

    }
}