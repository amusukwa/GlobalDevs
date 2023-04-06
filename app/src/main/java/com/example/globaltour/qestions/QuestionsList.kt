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
import androidx.core.graphics.Insets.add
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.globaltour.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


class QuestionsList : Fragment() {

    private lateinit var questionList: ArrayList<Question>
    private lateinit var questionAdapter: QuestionAdapter
    private lateinit var recyclerView: RecyclerView

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
        val recyclerView =  view?.findViewById<RecyclerView>(R.id.questions_recycler)
         recyclerView?.adapter = questionAdapter


        docRef.getReference("questions").
        addValueEventListener(object: ValueEventListener {
            @SuppressLint("SuspiciousIndentation")
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for(questionSnapshot in snapshot.children){

                    }
                   // val question = snapshot.getValue(Question::class.java)
                   //     Log.d(ContentValues.TAG,"error getting document ${question}")
                    snapshot.getValue(Question::class.java)?.let { questionList.add(it) }
                    Log.d(ContentValues.TAG,"error getting document ${questionList[0]}")

                    }
                  //  recyclerView?.adapter = questionAdapter(context,questionList)
                }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


    }}
