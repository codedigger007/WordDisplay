package com.example.worddisplay

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView


class WordFragment : Fragment() {

    val words = listOf<String>("ability", "able", "about", "above", "accept", "according", "account", "Bra", "Boss", "Bounce")
    val args: WordFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_word, container, false)
        val wordRecycler = view.findViewById<RecyclerView>(R.id.recyclerView2)
        val letterGotten = args.letterId
        val listGotten = words.filter{it.startsWith(letterGotten, ignoreCase = true)}.take(5).sorted()
        wordRecycler.adapter = WordAdapter(listGotten)

        return view

    }


}