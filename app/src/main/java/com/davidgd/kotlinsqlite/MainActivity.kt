package com.davidgd.kotlinsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.davidgd.kotlinsqlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Recuerda colocar en el build.gradle dentro de android {
    // buildFeatures{
    //        viewBinding = true
    //    }
    lateinit var binding: ActivityMainBinding
    lateinit var amigosDBHelper: miSQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        amigosDBHelper = miSQLiteHelper(this)

        binding.btGuardar.setOnClickListener {
            if (binding.etNombre.text.isEmpty() || binding.etEmail.text.isEmpty()){
                Toast.makeText(this,"No se guardo", Toast.LENGTH_LONG).show()
            }
            else {
                amigosDBHelper.anyadirDato(binding.etNombre.text.toString(), binding.etEmail.text.toString())
                binding.etNombre.text.clear()
                binding.etEmail.text.clear()
                Toast.makeText(this,"Guardado", Toast.LENGTH_LONG).show()
            }
        }
    }
}