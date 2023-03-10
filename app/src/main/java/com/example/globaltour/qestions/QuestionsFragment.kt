package com.example.globaltour.qestions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.globaltour.R
import com.google.firebase.database.FirebaseDatabase


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuestionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestionsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions, container, false)

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val addButton = view.findViewById<Button>(R.id.questionButton)
        addButton.setOnClickListener {
            val docRef = FirebaseDatabase.getInstance()

//            val cityName = view.findViewById<EditText>(R.id.city_name)
//            val countryName = view.findViewById<EditText>(R.id.country)
//
//            val name = cityName.text.toString()
//            val country = countryName!!.text.toString()
//
//
//            val globalCity = GlobalCity(name,country)
//            docRef.getReference("cities").child("globacities").push().setValue(globalCity)

        }




    }}




