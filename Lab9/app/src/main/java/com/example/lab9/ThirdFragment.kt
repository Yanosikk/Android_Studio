package com.example.lab9

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lab9.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private lateinit var binding: FragmentThirdBinding
    private var count = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.Increment.setOnClickListener {
            count++
            binding.tV.text = "Liczba wciśnięć przycisku $count"
        }

        binding.Decrement.setOnClickListener {
            count--
            binding.tV.text = "Liczba wciśnięć przycisku $count"
        }

        binding.Reset.setOnClickListener {
            count = 0
            binding.tV.text = "Liczba wciśnięć przycisku $count"
        }

        binding.btnBackToFirst.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({
                findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
            }, 1000)
        }

        binding.btnBackToSecond.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({
                findNavController().navigate(R.id.action_thirdFragment_to_secondFragment)
            }, 1000)
        }
    }

}
