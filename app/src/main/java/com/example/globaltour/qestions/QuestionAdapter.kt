package com.example.globaltour.qestions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.globaltour.R


class QuestionAdapter(val context: Context, var questionList: ArrayList<Question>,
                      val listener: OnItemClickListener )
:
    RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>(){

       inner class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

       private lateinit var question: Question

        private val questiontxt = itemView.findViewById<TextView>(R.id.username_txt)
        private val usernametxt= itemView.findViewById<TextView>(R.id.country_txt)

        fun bind(question: Question) {
            questiontxt.text = question.questionName
            usernametxt.text = question.username
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.question_item, parent, false)
        return QuestionViewHolder(itemView)
    }

    interface OnItemClickListener {
        fun onItemClick(question: Question)
    }
    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val question = questionList[position]
        holder.bind(question)
        holder.itemView.setOnClickListener {
            listener.onItemClick(question)
        }

    }

    override fun getItemCount(): Int {
        return questionList.size
    }



    fun updateQuestionList(updatedQuestionList: List<Question>) {
        questionList.clear()
       // questionList.addAll(newQuestionList)
        questionList.addAll(updatedQuestionList)
        notifyDataSetChanged()
    }

}