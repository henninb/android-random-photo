package com.bhenning.randomphoto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bhenning.randomphoto.databinding.ActivityMainBinding
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        fetchRandomPhoto(binding)
        //binding.imageView
        binding.randomButton.setOnClickListener {
            fetchRandomPhoto(binding)
        }

    }

    private fun fetchRandomPhoto(binding: ActivityMainBinding) {
        Picasso.get()
            .load("https://source.unsplash.com/random/640x960")
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .into(binding.imageView)
    }
}