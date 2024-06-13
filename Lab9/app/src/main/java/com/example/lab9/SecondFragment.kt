package com.example.lab9

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lab9.databinding.FragmentSecondBinding
import kotlin.random.Random

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pieniadz = listOf(R.drawable.awers, R.drawable.rewers)
        val teksty = listOf("Reszka", "Orzeł")

        binding.button.setOnClickListener {
            val index = Random.nextInt(0, pieniadz.size)
            Toast.makeText(requireContext(), "Rzucono monetą...", Toast.LENGTH_SHORT).show()
            animateCoinFlip(pieniadz[index])
            binding.tV.text = teksty[index]
        }

        binding.button2.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({
                findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
            }, 1000)
        }

        binding.buttonBackToFirst.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({
                findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
            }, 1000)
        }
    }

    private fun animateCoinFlip(newImageResource: Int) {
        val flipOutAnimator = ObjectAnimator.ofFloat(binding.imageView2, "rotationY", 0f, 90f)
        flipOutAnimator.duration = 250

        val flipInAnimator = ObjectAnimator.ofFloat(binding.imageView2, "rotationY", 270f, 360f)
        flipInAnimator.duration = 250

        flipOutAnimator.addUpdateListener {
            if (it.animatedFraction >= 0.5) {
                binding.imageView2.setImageResource(newImageResource)
            }
        }

        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(flipOutAnimator, flipInAnimator)
        animatorSet.start()
    }
}
