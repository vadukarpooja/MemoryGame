package com.example.memoryGame.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.memmorygame.R
import com.example.memoryGame.model.ColorsModel

class ResultAdapter(var list:ArrayList<ColorsModel>):
    RecyclerView.Adapter<ResultAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
       val txtNumber = view.findViewById<TextView>(R.id.txtNumber)
       val imgRight = view.findViewById<ImageView>(R.id.img)
       val imgWrong = view.findViewById<ImageView>(R.id.imgWrong)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultAdapter.ViewHolder {
      return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.raw_result_item,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val obj = list[position]
        holder.txtNumber.text = obj.name
        if (obj.name == obj.number){
            holder.imgRight.visibility = View.VISIBLE
            holder.imgWrong.visibility = View.GONE
        }
        else{
            holder.imgWrong.visibility = View.VISIBLE
            holder.imgRight.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
     return list.size
    }
}