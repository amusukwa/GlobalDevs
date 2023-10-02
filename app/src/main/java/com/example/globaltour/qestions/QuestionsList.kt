package com.example.globaltour.qestions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.globaltour.R
import com.example.globaltour.models.QuestionsViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class QuestionsList : Fragment(), QuestionAdapter.OnItemClickListener {

    private lateinit var questionList: ArrayList<Question>
    private lateinit var questionAdapter: QuestionAdapter
    private lateinit var question: Question
    private lateinit var recyclerView: RecyclerView
    private lateinit var firebasetext: TextView
    private lateinit var viewmodel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_questions_list, container, false)
        setUpRecyclerView(view)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        questionList = ArrayList()

        val recyclerView = view?.findViewById<RecyclerView>(R.id.questions_recycler)
        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.adapter = questionAdapter



        viewmodel = ViewModelProvider(this).get(QuestionsViewModel::class.java)
        (viewmodel as QuestionsViewModel).All_questions.observe(viewLifecycleOwner, Observer {

            questionList.addAll(it)
            questionAdapter.notifyDataSetChanged()
            questionAdapter.notifyDataSetChanged()
        })


        super.onViewCreated(view, savedInstanceState)
    }

    private fun setUpRecyclerView(view: View) {
        questionAdapter = QuestionAdapter(requireContext(), ArrayList(),this
        )

        val docRef = FirebaseDatabase.getInstance().getReference("questions")
        docRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                //val newQuestionList = ArrayList<Question>()
                questionList.clear()
                for (questionSnapshot in snapshot.children) {
                    val question = questionSnapshot.getValue(Question::class.java)
                    question?.let {
                        questionList.add(it)
                        //newQuestionList.add(it)
                    }
                }
                questionAdapter.updateQuestionList(questionList)
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireActivity(), "Error retrieving data", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    override fun onItemClick(question: Question) {
        Toast.makeText(requireContext(), "Clicked on question:" +
                " ${question.questionName}",
            Toast.LENGTH_SHORT).show()
    }
}