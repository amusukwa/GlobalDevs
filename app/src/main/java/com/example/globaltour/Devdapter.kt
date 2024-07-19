package com.example.globaltour

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.globaltour.qestions.Question

class Devdapter(val context: Context, var devList:ArrayList<Devprofile>)
    : RecyclerView.Adapter<Devdapter.DevViewHolder>() {
    inner class DevViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var devprofile: Devprofile

        private val questiontxt = itemView.findViewById<TextView>(R.id.questionName_txt)
        private val usernametxt= itemView.findViewById<TextView>(R.id.name_text)

        fun bind(question: Question) {
            questiontxt.text = question.questionName
            usernametxt.text = question.username
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DevViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: DevViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}