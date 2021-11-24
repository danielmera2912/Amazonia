package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentThirdBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    // cuando el fragmento se crea
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root

    }
    // cuando el fragmento se visualiza
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // crea un número aleatorio del 1 al 2, y según que resultado salga, realiza una parte de la condición
        val pago=(0 until 2).random()
        if(pago==1){
            // cuando se pulsa el botón se realiza la navegación indicada por su id
            binding.buttonThird.setOnClickListener {
                findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment)
            }
        }else{
            // cuando se pulsa el botón se realiza la navegación indicada por su id
            binding.buttonThird.setOnClickListener {
                findNavController().navigate(R.id.action_thirdFragment_to_fifthFragment)
            }
        }
    }
    // cuando el fragmento se cierra
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}