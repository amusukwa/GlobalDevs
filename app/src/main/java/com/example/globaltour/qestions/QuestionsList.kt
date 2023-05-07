package com.example.globaltour.qestions

import android.annotation.SuppressLint
import android.content.ContentValues
import android.graphics.Insets.add
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.Insets.add
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.globaltour.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener




class QuestionsList : Fragment() {

    private lateinit var questionList: ArrayList<Question>
    private lateinit var questionAdapter: QuestionAdapter
    private lateinit var question: Question
    private lateinit var recyclerView: RecyclerView
     private lateinit var firebasetext: TextView

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

          var docRef = FirebaseDatabase.getInstance()
          val context = requireContext()
          questionList =  arrayListOf<Question>()
         questionAdapter = QuestionAdapter(context, questionList)
      //   firebasetext = view?.findViewById<TextView>(R.id.firebasetext)!!
      //  val recyclerView =  view?.findViewById<RecyclerView>(R.id.questions_recycler)
      //   recyclerView?.adapter = questionAdapter


        docRef.getReference("questions").
        addValueEventListener(object: ValueEventListener {
            @SuppressLint("SuspiciousIndentation")
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(questionSnapshot in snapshot.children){

                    }
                    val question = snapshot.getValue(Question::class.java).toString()
                    snapshot.children.toString()

                    Log.d(ContentValues.TAG,"error getting document ${question}")

                   // Log.d(ContentValues.TAG,"error getting document ${questionList[0]}")

                    }
                  // recyclerView?.adapter = questionAdapter(context,questionList)
                }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@QuestionsList.requireActivity(), "saving", Toast.LENGTH_SHORT)
                    .show()
            }

        })


    }}
