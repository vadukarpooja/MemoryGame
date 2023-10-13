package com.example.memoryGame

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.memmorygame.R
import com.example.memmorygame.databinding.FragmentGameLevelBinding


class GameLevelFragment : Fragment() {

    lateinit var binding: FragmentGameLevelBinding
    val args: GameLevelFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentGameLevelBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
           Log.e(javaClass.simpleName, "onViewCreated: " + args.CompletLavel)

        binding.txtInfo.setOnClickListener {
            customDialog()
        }

        if (args.CompletLavel == COMPLETE_LEVEL2) {
            binding.imgLockLevel2.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.baseline_lock_open_24
                )
            )
        } else if (args.CompletLavel == COMPLETE_LEVEL3) {
            binding.imgLockLevel2.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.baseline_lock_open_24
                )
            )
            binding.imgLockLevel3.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.baseline_lock_open_24
                )
            )
        } else if (args.CompletLavel == COMPLETE_LEVEL1) {
            binding.imgLockLevel2.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.baseline_lock_open_24
                )
            )
        } else {
            binding.imgLockLevel2.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.baseline_lock_24
                )
            )
            binding.imgLockLevel3.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.baseline_lock_24
                )
            )
        }
        binding.btnLevel1.setOnClickListener {
            findNavController().navigate(
                GameLevelFragmentDirections.actionGameLevelFragmentToAddNumberFragment(
                    LEVEL1
                )
            )
        }

        binding.btnLevel2.setOnClickListener {
            if (args.CompletLavel == COMPLETE_LEVEL1) {
                binding.imgLockLevel2.visibility = View.GONE
                findNavController().navigate(
                    GameLevelFragmentDirections.actionGameLevelFragmentToAddNumberFragment(
                        LEVEL2
                    )
                )
            } else {
                Toast.makeText(
                    requireContext(),
                    "Beginning Level is Not Completed",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.btnLevel3.setOnClickListener {
            if (args.CompletLavel == COMPLETE_LEVEL2) {
                binding.imgLockLevel3.visibility = View.GONE
                binding.imgLockLevel2.visibility = View.GONE
                findNavController().navigate(
                    GameLevelFragmentDirections.actionGameLevelFragmentToAddNumberFragment(
                        LEVEL3
                    )
                )
            } else {
                Toast.makeText(
                    requireContext(),
                    "Beginning Level is Not Completed",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun customDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.custome_dialog)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.setCancelable(false)

        val txtDis: TextView = dialog.findViewById<TextView>(R.id.txtDis)
        val btnOk: Button = dialog.findViewById<Button>(R.id.btnOk)


         txtDis.text = HtmlCompat.fromHtml("<big><b><font color = \"#FFFFFF\">Memory Game</font></b></big><font color=\"#FFFFFF\"><small>A game is a structured form of play, usually undertaken" +
                 " for entertainment or fun, and sometimes used as an educational tool.</small></font>",HtmlCompat.FROM_HTML_MODE_LEGACY)

        btnOk.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
    }
   /* private fun alertDialog() {
        val builder = AlertDialog.Builder(requireContext())
        val title = HtmlCompat.fromHtml(
            "<big><b><font color = \"#0000\">Memory Game</font></b></big><font color=\"#0000\"><small>A game is a structured form of play, usually undertaken" +
                    " for entertainment or fun, and sometimes used as an educational tool.</small></font>",
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )
        builder.setTitle(title)
        builder.setPositiveButton("Yes") { _, _ ->
            Toast.makeText(requireContext(), "All Item is deleted", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss()
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }*/
