package com.hoodbrains.lbcttest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentFactory
import com.hoodbrains.lbctest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = createFragmentFactory()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    private fun createFragmentFactory(): FragmentFactory {
        val presentationFactory by app { providePresentationFactory() }
        return LbcFragmentFactory(AndroidViewModelFactory(presentationFactory))
    }
}