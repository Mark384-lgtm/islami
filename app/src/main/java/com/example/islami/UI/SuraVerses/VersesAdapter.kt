package com.example.islami.UI.SuraVerses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islami.R

class VersesAdapter(val verses: MutableList<String>) : Adapter<VersesAdapter.versesViewHolder>() {
    class versesViewHolder(itemView: View) : ViewHolder(itemView) {
        val tv_verse: TextView = itemView.findViewById(R.id.verses)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): versesViewHolder {
        val inflator: LayoutInflater = LayoutInflater.from(parent.context)
        val itemView = inflator.inflate(R.layout.item_verse, parent, false)
        return VersesAdapter.versesViewHolder(itemView)
    }

    override fun getItemCount(): Int = verses.size

    override fun onBindViewHolder(holder: versesViewHolder, position: Int) {
        holder.tv_verse.text = "${position + 1}-"
        holder.tv_verse.append(verses[position])

    }
}