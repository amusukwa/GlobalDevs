package com.example.globaltour.qestions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.globaltour.R
import com.example.globaltour.city.City


class QuestionAdapter(val context: Context, var QuestionList: ArrayList<Question>):
    RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {


    inner class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

       private lateinit var question: Question

        private val questiontxt = itemView.findViewById<TextView>(R.id.questionName_txt)
        private val usernametxt= itemView.findViewById<TextView>(R.id.username_text)

        fun bind(question: Question, position: Int) {

            questiontxt.text = question.questionName
            usernametxt.text = question.username

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.question_item, parent, false)
        return QuestionViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val question = QuestionList[position]
        holder.bind(question, position)

    }

    override fun getItemCount(): Int {
        return QuestionList.size
    }

}