package com.example.databindingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.databindingexample.databinding.ActivityMainBinding
import com.example.databindingexample.ui.MyViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
//        myViewModel.message.observe(this,{
//            binding.text.text = it
//        })
        binding.dataBinding = myViewModel
        binding.lifecycleOwner = this
        binding.dataText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                myViewModel.setMessage(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }
}