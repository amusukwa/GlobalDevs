package com.example.globaltour.qestions

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toolbar
import androidx.core.view.MenuProvider
import com.example.globaltour.MainActivity
import com.example.globaltour.MapsActivity
import com.example.globaltour.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.FirebaseDatabase





class QuestionsFragment : Fragment(),MenuProvider {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.addMenuProvider(this)
        val addButton = view.findViewById<Button>(R.id.questionButton)
        val floatingButton_map = view.findViewById<FloatingActionButton>(R.id.floatingActionButton_map)

        addButton.setOnClickListener {
            val docRef = FirebaseDatabase.getInstance()

            val questiontext = view.findViewById<EditText>(R.id.questionName)

            val name = view.findViewById<EditText>(R.id.username_text)

            val questionName = questiontext.text.toString()
            val username = name!!.text.toString()


            val question = Question(questionName,username)
            docRef.getReference("questions").push()
                .setValue(question)

            Toast.makeText(this@QuestionsFragment.requireActivity(),"saving",Toast.LENGTH_SHORT).show()
        }
        floatingButton_map.setOnClickListener {
            val intent = Intent (activity,MapsActivity::class.java)
            startActivity(intent)
        }

    }
    //creating the options menu
    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.map_menu,menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        if (menuItem.itemId == R.id.action_map) {
            Toast.makeText(this@QuestionsFragment.requireActivity(), "saving", Toast.LENGTH_SHORT)
                .show()
            return true

        }
        return true

    }


}





