package com.example.worddisplay

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class WordAdapter(val wordList: List<String>) : RecyclerView.Adapter<WordAdapter.WordHolder>() {

    class WordHolder(view: View) : RecyclerView.ViewHolder(view) {
        val butty = view.findViewById<Button>(R.id.button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordHolder {
        return WordAdapter.WordHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_lists, parent, false)
        )
    }

    override fun onBindViewHolder(holder: WordHolder, position: Int) {
       holder.butty.text = wordList[position]
        holder.butty.setOnClickListener {
            val itemGotten = holder.butty.text
            val SEARCH_PREFIX = "https://www.google.com/search?q="
            val querryUrl: Uri = Uri.parse(SEARCH_PREFIX + itemGotten.toString())
            val intent = Intent(Intent.ACTION_VIEW, querryUrl)
            it.context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return wordList.size
    }
}