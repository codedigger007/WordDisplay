package com.example.worddisplay

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat


class ListFragment : Fragment() {

    private var isLinearLayout = true
    lateinit var recyc: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        recyc = view.findViewById(R.id.recyclerView)
        chooseLayout()
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.layout_menu, menu)
        val layoutButton = menu?.findItem(R.id.change_menu)
        setIcon(layoutButton)
        // Calls code to set the icon based on the LinearLayoutManager of the RecyclerView
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.change_menu) {
            isLinearLayout = !isLinearLayout
            chooseLayout()
            setIcon(item)
            return true
        }
         else {
             return super.onOptionsItemSelected(item)
        }

    }

    fun chooseLayout() {
        if (isLinearLayout) {
            if (recyc != null) {
                recyc.layoutManager = LinearLayoutManager(context)
                recyc.adapter = LetterAdapter()
            }
        }
        else {
            if (recyc != null) {
                recyc.layoutManager = GridLayoutManager(context, 3)
                recyc.adapter = LetterAdapter()
            }
        }
    }

    fun setIcon(menuItem: MenuItem?) {
             if (isLinearLayout) {
                 ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_linear)
             }
                 else {
                 ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_linear)

             }
        }
    }