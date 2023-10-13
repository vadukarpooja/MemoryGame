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
import com.example.memmorygame.databinding.FragmentResultBinding
import com.example.memoryGame.COMPLETE_LEVEL1
import com.example.memoryGame.COMPLETE_LEVEL2
import com.example.memoryGame.COMPLETE_LEVEL3
import com.example.memoryGame.LEVEL1
import com.example.memoryGame.LEVEL2
import com.example.memoryGame.LEVEL3
import com.example.memoryGame.adapter.ResultAdapter
import com.example.memoryGame.model.ColorsModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class ResultFragment : Fragment() {
    lateinit var binding: FragmentResultBinding
   private val args: ResultFragmentArgs by navArgs()
    lateinit var adapter: ResultAdapter
    var completeLevel:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(javaClass.simpleName, "onViewCreated: " + args.resultList)
        val list: ArrayList<ColorsModel> =
            Gson().fromJson(args.resultList, object : TypeToken<List<ColorsModel>>() {}.type)
        val scoreValue = list.filter { it.name == it.number }
        Log.e(javaClass.simpleName, "onViewCreated: "+scoreValue.size )
        Log.e(javaClass.simpleName, "level: "+args.lavel )
        adapter = ResultAdapter(list)
        binding.recycleResult.adapter = adapter
        binding.txtScore.text = scoreValue.size.toString()
        binding.btnNextLevel.setOnClickListener {
                if (args.lavel == LEVEL1){
                    if (binding.txtScore.text.toString() != "2"){
                        Toast.makeText(requireContext(),"At Least 2 Score is Required",Toast.LENGTH_SHORT).show()
                        findNavController().navigate(ResultFragmentDirections.actionResultFragmentToAddNumberFragment(args.lavel))
                    }
                    else{
                        completeLevel = COMPLETE_LEVEL1
                        findNavController().navigate(ResultFragmentDirections.actionResultFragmentToGameLevelFragment(completeLevel))
                    }
                }
                else if (args.lavel == LEVEL2){
                    if (binding.txtScore.text.toString() !="8"){
                        Toast.makeText(requireContext(),"At Least 8 Score is Required",Toast.LENGTH_SHORT).show()
                        findNavController().navigate(ResultFragmentDirections.actionResultFragmentToAddNumberFragment(args.lavel))
                    }
                    else{
                        completeLevel = COMPLETE_LEVEL2
                        findNavController().navigate(ResultFragmentDirections.actionResultFragmentToGameLevelFragment(completeLevel))
                    }
                }
               else if (args.lavel == LEVEL3){
                   if (binding.txtScore.text.toString() !="12"){
                       Toast.makeText(requireContext(),"At Least 12 Score is Required",Toast.LENGTH_SHORT).show()
                       findNavController().navigate(ResultFragmentDirections.actionResultFragmentToAddNumberFragment(args.lavel))
                   }
                    else{
                       completeLevel = COMPLETE_LEVEL3
                       findNavController().navigate(ResultFragmentDirections.actionResultFragmentToGameLevelFragment(completeLevel))
                   }
                }
            }
        }

}