package com.example.myapplication

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.*
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.myapplication.MainActivity.Companion.producto
import com.example.myapplication.databinding.FragmentFirstBinding

class FirstViewModel : ViewModel() {

    private val _nomProd1: String= "Ordenador de sobremesa"
    val nomProd1: String
        get()=_nomProd1

    private val _nomProd2: String= "Ordenador portátil"
    val nomProd2: String
        get()=_nomProd2

    private val _precProd1: Double = 1500.0
    val precProd1: Double
        get()=_precProd1

    private val _precProd2: Double = 2500.0
    val precProd2: Double
        get()=_precProd2

    var prod1 = mutableMapOf<String, Double>(nomProd1 to precProd1)
    var prod2 = mutableMapOf<String, Double>(nomProd2 to precProd2)

/*
    binding.product1.setOnClickListener{
        MainActivity.producto = (MainActivity.producto +prod1) as MutableMap<Int, String>
    }
    binding.product2.setOnClickListener{
        MainActivity.producto = (MainActivity.producto +prod2) as MutableMap<Int, String>
    }
    */

    fun sumarProducto1(){
        producto = (producto+prod1) as MutableMap<String, Double>
    }
    fun sumarProducto2(){
        producto = (producto+prod2) as MutableMap<String, Double>
    }

}
