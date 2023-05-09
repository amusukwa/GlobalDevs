package com.example.globaltour.qestions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.globaltour.R
import com.example.globaltour.models.QuestionsViewModel


class QuestionsList : Fragment() {

    private lateinit var questionList: ArrayList<Question>
    private lateinit var questionAdapter: QuestionAdapter
    private lateinit var question: Question
    private lateinit var recyclerView: RecyclerView
    private lateinit var firebasetext: TextView
    private lateinit var viewmodel:ViewModel

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


        val recyclerView =  view?.findViewById<RecyclerView>(R.id.questions_recycler)
        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.adapter = questionAdapter

        viewmodel = ViewModelProvider(this).get(QuestionsViewModel::class.java)


        super.onViewCreated(view, savedInstanceState)
    }

    private fun setUpRecyclerView(view: View?) {

//          var docRef = FirebaseDatabase.getInstance()
//          val context = requireContext()
//          questionList =  arrayListOf<Question>()
//         questionAdapter = QuestionAdapter(context, questionList)
//      //   firebasetext = view?.findViewById<TextView>(R.id.firebasetext)!!
//      //  val recyclerView =  view?.findViewById<RecyclerView>(R.id.questions_recycler)
//      //   recyclerView?.adapter = questionAdapter
//
//
//        docRef.getReference("questions").
//        addValueEventListener(object: ValueEventListener {
//            @SuppressLint("SuspiciousIndentation")
//            override fun onDataChange(snapshot: DataSnapshot) {
//                if(snapshot.exists()){
//                    for(questionSnapshot in snapshot.children){
//
//                    }
//                    val question = snapshot.getValue(Question::class.java).toString()
//                    snapshot.children.toString()
//
//                    Log.d(ContentValues.TAG,"error getting document ${question}")
//
//                   // Log.d(ContentValues.TAG,"error getting document ${questionList[0]}")
//
//                    }
//                  // recyclerView?.adapter = questionAdapter(context,questionList)
//                }
//
//            override fun onCancelled(error: DatabaseError) {
//                Toast.makeText(this@QuestionsList.requireActivity(), "saving", Toast.LENGTH_SHORT)
//                    .show()
//            }
//
//        })
//

    }}
