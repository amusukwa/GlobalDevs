package com.example.globaltour.qestions

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.globaltour.R
import com.example.globaltour.city.City


class QuestionAdapter(val context: Context, var QuestionList: ArrayList<Question>):
    RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {


    inner class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        private var currentPosition: Int = -1
       private lateinit var question: Question

        private val questiontxt = itemView.findViewById<TextView>(R.id.question_text)
        private val usernametxt= itemView.findViewById<TextView>(R.id.username_text)

        fun setData(city: City, position: Int) {

            questiontxt.text = question.questionName
            usernametxt.text = question.username


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}