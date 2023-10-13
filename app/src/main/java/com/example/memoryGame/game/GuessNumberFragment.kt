package com.example.memoryGame.game

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.memmorygame.databinding.FragmentGuessNumberBinding
import com.example.memoryGame.VIEW_TYPE_LABEL
import com.example.memoryGame.adapter.BoxListAdapter
import com.example.memoryGame.model.ColorsModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class GuessNumberFragment : Fragment() {
    lateinit var binding: FragmentGuessNumberBinding
    lateinit var adapter: BoxListAdapter
    val args: GuessNumberFragmentArgs by navArgs()
    var isEmpty = false
    var isFourDigits:Boolean = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGuessNumberBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data: ArrayList<ColorsModel> =
            Gson().fromJson(args.boxList, object : TypeToken<List<ColorsModel>>() {}.type)
        Log.e(javaClass.simpleName, "onViewCreated data: $data")
        Log.e(javaClass.simpleName, "level: "+args.lavel )
        val randomList = data.shuffled()
        adapter = BoxListAdapter(requireContext(),randomList as ArrayList<ColorsModel>, VIEW_TYPE_LABEL)
        binding.recycle.adapter = adapter

        binding.btnNext.setOnClickListener {
            findNavController().navigate(
                GuessNumberFragmentDirections.actionGuessNumberFragmentToResultFragment(args.lavel,
                    Gson().toJson(randomList)
                )
            )
        }
    }

}