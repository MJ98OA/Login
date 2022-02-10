package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import com.example.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var nombre = false
    private var contra = false

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.contrasenia.doAfterTextChanged {

            it?.let {
                contra = it.contains("(?=.*[a-zA-Z])(?=.*[0-9])".toRegex()) && it.length >= 8
                activar(nombre,contra)
            }
        }

        binding.nombre.doAfterTextChanged {

            it?.let { nombre = it.length >= 3
                activar(nombre,contra)}
        }

    }

    fun activar(nomb:Boolean,cont: Boolean) {

        if (cont && nomb) {
            binding.boton.visibility = View.VISIBLE
        } else
            binding.boton.visibility = View.GONE
    }


}