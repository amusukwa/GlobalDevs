package com.example.globaltour.qestions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.globaltour.R

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class QuestionsList : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_questions_list, container, false)
        setUpRecyclerView(view)
        return view

}

    private fun setUpRecyclerView(view: View?) {

    }}
