package com.example.globaltour

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.globaltour.qestions.Question
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.FirebaseDatabase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DevFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DevFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dev, container, false)
    }
   // val addButton = view.findViewById<Button>(R.id.questionButton)

//    addButton.setOnClickListener {
//        val docRef = FirebaseDatabase.getInstance()
//
//        val questiontext = view.findViewById<EditText>(R.id.questionName)
//
//        val name = view.findViewById<EditText>(R.id.username_text)
//
//        val questionName = questiontext.text.toString()
//        val username = name!!.text.toString()
//
//
//        val question = Question(questionName,username)
//        docRef.getReference("questions").push()
//            .setValue(question)
//
//        Toast.makeText(this@QuestionsFragment.requireActivity(),"saving", Toast.LENGTH_SHORT).show()
//    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DevFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DevFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}