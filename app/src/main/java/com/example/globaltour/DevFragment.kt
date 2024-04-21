package com.example.globaltour

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.MenuProvider
import com.example.globaltour.qestions.Question
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.FirebaseDatabase
import com.example.globaltour.Devprofile

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class DevFragment : Fragment(), MenuProvider {
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_dev, container, false)

        }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            activity?.addMenuProvider(this)
            val addButton = view.findViewById<Button>(R.id.devButton)

            addButton.setOnClickListener {
                val docRef = FirebaseDatabase.getInstance()

                val dev_name = view.findViewById<EditText>(R.id.dev_name)

                val dev_skill = view.findViewById<EditText>(R.id.skill_spin)
                val dev_email = view.findViewById<EditText>(R.id.dev_email)
                val dev_location = view.findViewById<EditText>(R.id.dev_country)
                val uid = "q5777r93"



                val name = dev_name.text.toString()
                val skills = dev_skill!!.text.toString().split(",")
                val email = dev_email!!.text.toString()
                val location = dev_location.text.toString()


                val devprof = Devprofile(uid,name,skills,email,location)
                docRef.getReference("devprofile").push()
                    .setValue(devprof)

                Toast.makeText(this@DevFragment.requireActivity(),"saving",Toast.LENGTH_SHORT).show()
            }

        }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        TODO("Not yet implemented")
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        TODO("Not yet implemented")
    }
    //creating the options menu
//        override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
//            menuInflater.inflate(R.menu.map_menu,menu)
//        }
//
//        override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
//            if (menuItem.itemId == R.id.action_map) {
//                Toast.makeText(this@QuestionsFragment.requireActivity(), "saving", Toast.LENGTH_SHORT)
//                    .show()
//                return true
//
//            }
//            return true
//
//        }


    }





