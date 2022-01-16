package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.MainActivity.Companion.direccionD
import com.example.myapplication.MainActivity.Companion.nombreD
import com.example.myapplication.MainActivity.Companion.producto
import com.example.myapplication.databinding.FragmentFourthBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
private const val ARG_PARAM1= "param1"
class FourthFragment : Fragment() {
    private var param1: String? = null
    private var _binding: FragmentFourthBinding? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // cuando el fragmento se crea
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFourthBinding.inflate(inflater, container, false)
        return binding.root

    }
    // cuando el fragmento se visualiza
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // cuando se pulsa el botón se realiza la navegación indicada por su id
        var mensaje:String=""
        for ((precio, nombre) in producto) {
            mensaje += nombre + "a" + precio +"€"+ "\n"
        }
        binding.pedido.setText("Producto: "+mensaje+", para la dirección: "+direccionD+", consta a este nombre: "+nombreD)
        binding.buttonFourth.setOnClickListener {
            findNavController().navigate(R.id.action_fourthFragment_to_FirstFragment)
        }

    }
    // cuando el fragmento se cierra
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}