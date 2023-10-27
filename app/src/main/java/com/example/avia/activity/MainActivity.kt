package com.example.avia.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.avia.R
import com.example.avia.databinding.ActivityMainBinding
import com.example.avia.fragment.OfferListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view, OfferListFragment.newInstance())
            .commit()

    }
}