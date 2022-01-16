package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.example.myapplication.MainActivity.Companion.producto
import com.example.myapplication.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    // cuando el fragmento se crea
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }
    // cuando el fragmento se visualiza
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // cuando se pulsa el botón se realiza la navegación indicada por su id
        //var producto=  bundleOf("param2" to "Sin producto")
        binding.product1.setOnClickListener{
            producto.put(1500,binding.product1.text.toString())
            //producto.add(binding.product1.text as String)
        }
        binding.product2.setOnClickListener{
            producto.put(2500,binding.product2.text.toString())
            //producto.add(binding.product2.text as String)
        }
        binding.buttonFirst.setOnClickListener {
            if (!binding.product1.isChecked && !binding.product2.isChecked ) {
                Toast.makeText(
                    applicationContext,
                    "Debe seleccionar al menos un producto",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        }
    }
    // cuando el fragmento se cierra
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
