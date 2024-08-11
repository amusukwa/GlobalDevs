
package com.example.globaltour

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.globaltour.qestions.Question

class Devdapter(val context: Context, var devList:ArrayList<Devprofile>)
    : RecyclerView.Adapter<Devdapter.DevViewHolder>() {
    inner class DevViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var devprofile: Devprofile

        private val name = itemView.findViewById<TextView>(R.id.prof_name_txt)
        private val country= itemView.findViewById<TextView>(R.id.country_txt)

        fun bind(devprofile: Devprofile) {
            name.text = devprofile.name
            country.text = devprofile.location
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DevViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.dev_profile_item, parent, false)
        return DevViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DevViewHolder, position: Int) {
        val devprofile = devList[position]
        holder.bind(devprofile)
//        holder.itemView.setOnClickListener {
//            listener.onItemClick(devprofile)
//        }
    }

    override fun getItemCount():Int {
         return devList.size
    }

    fun updateDevList(newDevList: ArrayList<Devprofile>) {
        devList = newDevList
        notifyDataSetChanged()
    }

}
