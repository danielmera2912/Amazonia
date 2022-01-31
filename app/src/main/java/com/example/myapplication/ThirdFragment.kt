package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
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
        val bundle= bundleOf("param1" to "Pago autorizado: "+pago.toString())
        /*
        if(pago==1){
            // cuando se pulsa el botón se realiza la navegación indicada por su id
            binding.buttonThird.setOnClickListener {
                findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment,bundle)
            }
        }else{
            // cuando se pulsa el botón se realiza la navegación indicada por su id
            binding.buttonThird.setOnClickListener {
                findNavController().navigate(R.id.action_thirdFragment_to_fifthFragment,bundle)
            }
        }

         */
        binding.us.setVisibility(View.INVISIBLE)
        binding.usRe.setVisibility(View.INVISIBLE)
        binding.cla.setVisibility(View.INVISIBLE)
        binding.claRe.setVisibility(View.INVISIBLE)

        binding.iban.setVisibility(View.INVISIBLE)
        binding.ibanRe.setVisibility(View.INVISIBLE)
        binding.op1.setOnClickListener{
            if(binding.op1.isChecked){
                binding.us.setVisibility(View.VISIBLE)
                binding.usRe.setVisibility(View.VISIBLE)
                binding.cla.setVisibility(View.VISIBLE)
                binding.claRe.setVisibility(View.VISIBLE)
                binding.iban.setVisibility(View.INVISIBLE)
                binding.ibanRe.setVisibility(View.INVISIBLE)
                /*
                binding.buttonThird.setOnClickListener {
                    findNavController().navigate(R.id.action_thirdFragment_to_fifthFragment,bundle)
                }
*/
                var textoUs=""
                var textoCla= ""




                binding.buttonThird.setOnClickListener {
                    textoUs= binding.usRe.getText().toString()
                    textoCla=binding.claRe.getText().toString()
                    if(textoUs.length<2 || textoCla.length<2){
                        findNavController().navigate(R.id.action_thirdFragment_to_fifthFragment,bundle)
                    }else{
                        findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment,bundle)
                    }

                }




            }
            else{
                binding.iban.setVisibility(View.VISIBLE)
                binding.ibanRe.setVisibility(View.VISIBLE)
                binding.us.setVisibility(View.INVISIBLE)
                binding.usRe.setVisibility(View.INVISIBLE)
                binding.cla.setVisibility(View.INVISIBLE)
                binding.claRe.setVisibility(View.INVISIBLE)

            }
        }
        binding.op2.setOnClickListener{
            if(binding.op2.isChecked){
                binding.iban.setVisibility(View.VISIBLE)
                binding.ibanRe.setVisibility(View.VISIBLE)
                binding.us.setVisibility(View.INVISIBLE)
                binding.usRe.setVisibility(View.INVISIBLE)
                binding.cla.setVisibility(View.INVISIBLE)
                binding.claRe.setVisibility(View.INVISIBLE)
                var textoIBAN=""
                binding.buttonThird.setOnClickListener {
                    textoIBAN= binding.ibanRe.getText().toString()
                    if(textoIBAN.length<2){
                        findNavController().navigate(R.id.action_thirdFragment_to_fifthFragment,bundle)
                    }else{
                        findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment,bundle)
                    }
                }
            }
        }
    }
    // cuando el fragmento se cierra
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}