package models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.globaltour.qestions.Question
import repository.QuestionsRepository

class QuestionViewModel() : ViewModel() {
    private val repository: QuestionsRepository
    private val all_questions = MutableLiveData<List<Question>>()
    val All_questions : MutableLiveData<List<Question>> = all_questions

    //initialization
    init {
        repository = QuestionsRepository().getInstance()
         repository.loadQuestions(all_questions)

    }
}