package com.example.testpitest

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso

class MainActivity : FragmentActivity() {
    private lateinit var mainViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageview = findViewById<ImageView>(R.id.imageview)
        Picasso.get()
            .load("https://img2.freepng.fr/20180621/jss/kisspng-lidl-grocery-store-discount-shop-retail-aldi-5b2b2bce57eaa0.3251713115295559183601.jpg")
            .into(imageview)

        val button = findViewById<Button>(R.id.button_submit)
        button.setOnClickListener { _ ->
            mainViewModel.buttonClick()
        }

        mainViewModel.isImageVisible.observe(this) {
            imageview.isVisible = it
        }

        mainViewModel.updateName.observe(this) {
            button.text = it
        }

    }
}