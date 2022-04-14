package com.example.worddisplay

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

class LetterAdapter : RecyclerView.Adapter<LetterAdapter.LetterHolder>() {
    private val letters = ('A').rangeTo('Z').toList()
    class LetterHolder(view: View) : RecyclerView.ViewHolder(view) {
        val butty = view.findViewById<Button>(R.id.button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterHolder {
        return LetterAdapter.LetterHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lists, parent, false))

    }

    override fun onBindViewHolder(holder: LetterHolder, position: Int) {
        holder.butty.text = letters[position].toString()
        holder.butty.setOnClickListener {
            val lettered = holder.butty.text.toString()
            val action = ListFragmentDirections.actionListFragmentToWordFragment(letterId = lettered)
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return letters.size
    }
}