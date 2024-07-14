package com.example.globaltour

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.globaltour.models.QuestionsViewModel
import com.example.globaltour.qestions.Question
import com.example.globaltour.qestions.QuestionAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener




//class DevlistFragment : Fragment() {
//
//private lateinit var devList: ArrayList<DevProfile>
//private lateinit var recyclerView: RecyclerView
//private lateinit var viewmodel: ViewModel
//
//override fun onCreateView(
//inflater: LayoutInflater, container: ViewGroup?,
//savedInstanceState: Bundle?
//): View? {
//// Inflate the layout for this fragment
//val view = inflater.inflate(R.layout.fragment_questions_list, container, false)
//setUpRecyclerView(view)
//return view
//
//}
//
//override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//devList = ArrayList()
//
//val recyclerView = view?.findViewById<RecyclerView>(R.id.questions_recycler)
//recyclerView?.layoutManager = LinearLayoutManager(context)
//recyclerView?.setHasFixedSize(true)
//recyclerView?.adapter = questionAdapter
//
//
//
//viewmodel = ViewModelProvider(this).get(QuestionsViewModel::class.java)
//(viewmodel as QuestionsViewModel).All_questions.observe(viewLifecycleOwner, Observer {
//
//devList.addAll(it)
//questionAdapter.notifyDataSetChanged()
//questionAdapter.notifyDataSetChanged()
//})
//
//
//super.onViewCreated(view, savedInstanceState)
//}

//private fun setUpRecyclerView(view: View) {
//questionAdapter = QuestionAdapter(requireContext(), ArrayList(),this
//)
//
//val docRef = FirebaseDatabase.getInstance().getReference("questions")
//docRef.addValueEventListener(object : ValueEventListener {
//override fun onDataChange(snapshot: DataSnapshot) {
////val newQuestionList = ArrayList<Question>()
//devList.clear()
//for (questionSnapshot in snapshot.children) {
//val question = questionSnapshot.getValue(Question::class.java)
//question?.let {
//devList.add(it)
////newQuestionList.add(it)
//}
//}
//questionAdapter.updateQuestionList(devList)
//}
//
//override fun onCancelled(error: DatabaseError) {
//Toast.makeText(requireActivity(), "Error retrieving data", Toast.LENGTH_SHORT)
//.show()
//}
//})
//}
//
//override fun onItemClick(question: Question) {
//// Obtain a reference to the Firebase Realtime Database
//val databaseReference = FirebaseDatabase.getInstance().getReference("questions")
//
//// Identify the key of the item you want to delete (assuming there's a key field in your Question class)
//val itemKeyToDelete = question.questionName
//
//databaseReference.child(itemKeyToDelete).removeValue().addOnSuccessListener {
//Toast.makeText(requireContext(), "Deleted: ${question.questionName}", Toast.LENGTH_SHORT).show()
//}.addOnFailureListener {
//Toast.makeText(requireContext(), "Failed to delete: ${it.message}", Toast.LENGTH_SHORT).show()
//}}
//
//
//}