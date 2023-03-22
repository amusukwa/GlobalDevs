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

            val questiontext = view.findViewById<EditText>(R.id.questionName)

            val name = view.findViewById<EditText>(R.id.username_text)

            val questionName = questiontext.text.toString()
            val username = name!!.text.toString()


            val question = Question(questionName,username)
            docRef.getReference("questions").child("questions").push()
                .setValue(question)

        }




    }}




