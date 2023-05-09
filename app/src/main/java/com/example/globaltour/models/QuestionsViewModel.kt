package com.example.globaltour.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.globaltour.qestions.Question
import com.example.globaltour.repository.QuestionRepository

class QuestionsViewModel : ViewModel() {
    private val repository: QuestionRepository
    private val all_questions = MutableLiveData<List<Question>>()
    val All_questions : MutableLiveData<List<Question>> = all_questions

    //initialization
    init {
        repository = QuestionRepository().getInstance()
        repository.loadQuestions(all_questions)

    }
}