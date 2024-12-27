package com.example.islami.UI.home.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islami.R

class Adapter_sur(val sur_DataCLass_list: MutableList<SurDataCLass>) :
    Adapter<Adapter_sur.sur_ViewHolder>() {
    class sur_ViewHolder(itemView: View) : ViewHolder(itemView) {
        val Tv_suraname: TextView = itemView.findViewById(R.id.tv_tittle)
        val Tv_versesCount: TextView = itemView.findViewById(R.id.tv_count_verses)
    }

    lateinit var ref_ItemComponetClick: ItemComponentClick
    lateinit var versesCount: CountLines


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): sur_ViewHolder {
        val inflator: LayoutInflater = LayoutInflater.from(parent.context)
        val itemview: View = inflator.inflate(R.layout.item_sora_title, parent, false)
        return sur_ViewHolder(itemview)
    }


    override fun getItemCount(): Int {
        return sur_DataCLass_list.size
    }

    override fun onBindViewHolder(holder: sur_ViewHolder, position: Int) {
        holder.Tv_suraname.text = sur_DataCLass_list[position].name//Bind
        holder.Tv_versesCount.text = versesCount.Count(position).toString()
        holder.itemView.setOnClickListener {
            ref_ItemComponetClick.click(
                position,
                holder.Tv_suraname.text as String
            )
        }
    }

    fun interface ItemComponentClick {
        fun click(position: Int, tittle: String)
    }

    fun interface CountLines {
        fun Count(position: Int): Int
    }


}