package com.example.memoryGame.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.memmorygame.R
import com.example.memoryGame.VIEW_TYPE_NUMBER
import com.example.memoryGame.model.ColorsModel


class BoxListAdapter(var context: Context, var list:ArrayList<ColorsModel>, val viewType:Int):
    RecyclerView.Adapter<BoxListAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val number: TextView = view.findViewById<TextView>(R.id.number)
        val label: TextView = view.findViewById<TextView>(R.id.number1)
        val edtNumber: EditText = view.findViewById<EditText>(R.id.edtNumber)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.raw_box_list,parent,false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val obj = list[position]
        holder.number.text = obj.id + "."
        holder.label.text = obj.name
        if (viewType == VIEW_TYPE_NUMBER){
            holder.label.visibility = View.VISIBLE
            holder.edtNumber.visibility = View.GONE
        }
        else{
            holder.edtNumber.visibility = View.VISIBLE
            holder.label.visibility = View.GONE
        }
        holder.edtNumber.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
               obj.number = s.toString()
                Log.e(javaClass.simpleName, "onTextChanged: $s")
            }
        })

    }

    override fun getItemCount(): Int {
        return list.size
    }
}