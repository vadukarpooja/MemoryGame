package com.example.memoryGame.game

import android.os.Bundle
import android.text.InputFilter
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.memmorygame.databinding.FragmentAddNumberBinding
import com.example.memoryGame.LEVEL1
import com.example.memoryGame.LEVEL2
import com.example.memoryGame.MinMaxFilter


class AddNumberFragment : Fragment() {
  lateinit var binding: FragmentAddNumberBinding
  val args:AddNumberFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddNumberBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        when (args.lavel) {
            LEVEL1 -> {
                binding.edtNumber.filters = arrayOf<InputFilter>(MinMaxFilter(2,4))
            }
            LEVEL2 -> {
                binding.edtNumber.filters = arrayOf<InputFilter>(MinMaxFilter(5,7))
            }
            else -> {
                binding.edtNumber.filters = arrayOf<InputFilter>(MinMaxFilter(8,9))
            }
        }
        binding.btnNext.setOnClickListener {
            if (TextUtils.isEmpty(binding.edtNumber.text)){
                Toast.makeText(requireContext(),"Number is Required",Toast.LENGTH_SHORT).show()
            }
            else{
                findNavController().navigate(AddNumberFragmentDirections.actionAddNumberFragmentToRememberOfNumber(args.lavel,binding.edtNumber.text.toString()))
            }

        }
    }
}