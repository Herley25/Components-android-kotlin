package com.example.components

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import com.example.components.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

     private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        // attribution um event
        binding.buttonToast.setOnClickListener(this)
        binding.buttonSnack.setOnClickListener(this)
    }

     override fun onClick(v: View?) {
         if (v != null) {
             when (v.id) {
                 R.id.button_toast -> {
                     val toast = Toast.makeText(this, "Toast", Toast.LENGTH_SHORT)
                     toast.show()
                 }
                 // customization da snack
                 R.id.button_snack -> {
                     val snack = Snackbar.make(binding.linearRoot, "Snack", Snackbar.LENGTH_SHORT)
                     snack.setBackgroundTint(Color.GREEN)
                     snack.setTextColor(Color.BLACK)
                     snack.show()
                 }
             }
         }
     }
 }