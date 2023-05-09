package com.example.globaltour.repository

import androidx.lifecycle.MutableLiveData
import com.example.globaltour.qestions.Question
import com.google.firebase.database.*

class QuestionRepository {
    private   val databaseReference: DatabaseReference =  FirebaseDatabase.getInstance()
        .getReference("questions")
    @Volatile  private var INSTANCE: QuestionRepository?= null
    fun getInstance(): QuestionRepository {
        return INSTANCE?: synchronized(this){
            val instance = QuestionRepository()
            INSTANCE = instance
            instance
        }
    }

    fun loadQuestions(questionsList: MutableLiveData<List<Question>>){
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val _questionsList : List<Question> = snapshot.children.map { dataSnapshot ->
                        dataSnapshot.getValue(Question::class.java)!!
                    }
                    questionsList.postValue(_questionsList)
                } catch (e : Exception){}
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}