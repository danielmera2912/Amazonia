package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
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
        var producto=  bundleOf("param2" to "Sin producto")
        binding.product1.setOnClickListener{
            producto= bundleOf("param2" to "Ordenador de sobremesa")
        }
        binding.product2.setOnClickListener{
            producto= bundleOf("param2" to "Ordenador portátil")
        }
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,producto)
        }
    }
    // cuando el fragmento se cierra
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
