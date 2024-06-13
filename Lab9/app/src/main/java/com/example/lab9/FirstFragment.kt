package com.example.lab9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lab9.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            if (binding.etweight.text.isNotEmpty() && binding.etheight.text.isNotEmpty()) {
                val height = binding.etheight.text.toString().toInt()
                val weight = binding.etweight.text.toString().toInt()

                val BMI: Float = calculateBMI(height, weight)

                binding.bmi.text = BMI.toString()
                binding.bmi.visibility = View.VISIBLE

                when {
                    BMI < 18.5 -> binding.resultIV.setImageResource(R.drawable.uw)
                    BMI in 18.5..24.9 -> binding.resultIV.setImageResource(R.drawable.n)
                    BMI in 25.0..29.9 -> binding.resultIV.setImageResource(R.drawable.ow)
                    BMI in 30.0..34.9 -> binding.resultIV.setImageResource(R.drawable.o)
                    BMI >= 35 -> binding.resultIV.setImageResource(R.drawable.eo)
                }
                binding.resultIV.visibility = View.VISIBLE
            } else {
                Toast.makeText(context, "Podaj właściwą wagę oraz wzrost", Toast.LENGTH_SHORT).show()
            }
        }

        binding.navButton.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        binding.buttonToThirdFragment.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun calculateBMI(height: Int, weight: Int): Float {
        val heightMetre = height.toFloat() / 100
        val weightMetre = weight.toFloat()
        return weightMetre / (heightMetre * heightMetre)
    }
}
