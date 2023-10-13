package com.example.memoryGame.game

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.memmorygame.databinding.FragmentShowListofNumberBinding
import com.example.memoryGame.VIEW_TYPE_NUMBER
import com.example.memoryGame.adapter.BoxListAdapter
import com.example.memoryGame.model.ColorsModel
import com.example.memoryGame.numberList
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.google.gson.Gson


class RememberOfNumber : Fragment() {
     lateinit var binding: FragmentShowListofNumberBinding
     lateinit var  adapter: BoxListAdapter
     val args: RememberOfNumberArgs by navArgs()
     var multiPlyNumber:Int = 0


        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentShowListofNumberBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        multiPlyNumber = args.number.toInt()
        val answer = multiPlyNumber * args.number.toInt()
        Log.e(javaClass.simpleName, "onViewCreated: $answer")
        Log.e(javaClass.simpleName, "level: "+args.lavel )
        val list = numberList().shuffled()
        val takeList = list.take(answer)
        Log.e(javaClass.simpleName, "onViewCreated: $takeList")

        adapter = BoxListAdapter(requireContext(),list = takeList as ArrayList<ColorsModel>, VIEW_TYPE_NUMBER)
        binding.recycleBox.adapter = adapter
        binding.recycleBox.apply {
            layoutManager = FlexboxLayoutManager(context).apply {
                flexWrap = FlexWrap.WRAP
                flexDirection = FlexDirection.ROW
                justifyContent = JustifyContent.SPACE_BETWEEN
            }
            adapter = adapter
        }

        binding.btnNext.setOnClickListener {
            findNavController().navigate(RememberOfNumberDirections.actionRememberOfNumberToGuessNumberFragment(args.lavel,Gson().toJson(takeList)))
        }
    }

}