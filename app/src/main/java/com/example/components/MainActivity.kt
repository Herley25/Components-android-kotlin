package com.example.components

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import android.widget.Toast
import com.example.components.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener {

     private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        // attribution um event
        binding.buttonToast.setOnClickListener(this)
        binding.buttonSnack.setOnClickListener(this)

        binding.buttonGetSpinner.setOnClickListener(this)
        binding.buttonSetSpinner.setOnClickListener(this)
        // propriedade e atribuimos desta maneira
        binding.spinnerDinamic.onItemSelectedListener = this

        //loadSpinner()
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

                 R.id.button_get_spinner -> {

                     loadSpinner()
                     //val str = binding.spinnerDinamic.selectedItem

                     //val id1 = binding.spinnerDinamic.selectedItemId
                     //val id2 = binding.spinnerDinamic.selectedItemPosition
                 }
                 R.id.button_set_spinner -> {

                    binding.spinnerDinamic.adapter = null

                    //binding.spinnerDinamic.setSelection(2)
                 }
             }
         }
     }

    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        Toast.makeText(this, "$position - $id", Toast.LENGTH_SHORT).show()
    }

    // Quando nada é selecionado
    override fun onNothingSelected(parent: AdapterView<*>) {
        Toast.makeText(this, "NOTHING", Toast.LENGTH_SHORT).show()
    }

    //* a lista do spinner pode ser dinâmica, vindo do backend por exemplo
    private fun loadSpinner() {
        val list = listOf("Gramas", "Kg", "Arroba", "Tonelada")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)
        binding.spinnerDinamic.adapter = adapter
    }
}