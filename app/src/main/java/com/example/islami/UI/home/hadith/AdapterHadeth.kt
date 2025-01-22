package com.example.islami.UI.home.hadith

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemHadithTitleBinding

class AdapterHadeth(val ahadethlist: List<HadethDataClass>) :
    RecyclerView.Adapter<AdapterHadeth.HadehViewHolder>() {

    var onItemClickListner: OnItemClickListner? = null

    class HadehViewHolder(val bindig: ItemHadithTitleBinding) :
        RecyclerView.ViewHolder(bindig.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadehViewHolder {
        val binding: ItemHadithTitleBinding =
            ItemHadithTitleBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return HadehViewHolder(binding)
    }

    override fun getItemCount(): Int = ahadethlist.size

    override fun onBindViewHolder(holder: HadehViewHolder, position: Int) {

        holder.bindig.tvTittle.text = ahadethlist[position].title


        holder.itemView.setOnClickListener { onItemClickListner?.OnItemClick(position) }
    }


    fun interface OnItemClickListner {
        fun OnItemClick(position: Int)
    }


}