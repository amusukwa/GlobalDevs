package com.example.globaltour

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import com.google.firebase.database.FirebaseDatabase
import com.example.globaltour.Devprofile
import com.google.android.material.textfield.TextInputLayout

class DevFragment : Fragment(), MenuProvider, AdapterView.OnItemSelectedListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dev, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.addMenuProvider(this)

        val addButton = view.findViewById<Button>(R.id.devButton)

        addButton.setOnClickListener {
            val devNameLayout = view.findViewById<TextInputLayout>(R.id.dev_name)
            val devSkillLayout = view.findViewById<TextInputLayout>(R.id.dev_skill)
            val devEmailLayout = view.findViewById<TextInputLayout>(R.id.dev_email)
            val devLocationLayout = view.findViewById<TextInputLayout>(R.id.dev_country)

            val devName = devNameLayout.editText?.text.toString().trim()
            val devSkill = devSkillLayout.editText?.text.toString().trim()
            val devEmail = devEmailLayout.editText?.text.toString().trim()
            val devLocation = devLocationLayout.editText?.text.toString().trim()

            if (devName.isEmpty() || devSkill.isEmpty() || devEmail.isEmpty() || devLocation.isEmpty()) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val devProf = Devprofile(devName, devSkill, devEmail, devLocation)

            val database = FirebaseDatabase.getInstance().reference
            val key = database.child("devprofile").push().key
            if (key == null) {
                Toast.makeText(requireContext(), "Failed to generate key", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            database.child("devprofile").child(key).setValue(devProf)
                .addOnSuccessListener {
                    Toast.makeText(requireContext(), "Profile saved successfully", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(requireContext(), "Failed to save profile: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        }
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        // Implement menu creation here if needed
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        // Handle menu item selection here if needed
        return false
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        // Handle selection of skill
        val selectedSkill = parent?.getItemAtPosition(position).toString()
        Toast.makeText(requireContext(), "Selected skill: $selectedSkill", Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(requireContext(), "No skill selected", Toast.LENGTH_SHORT).show()
    }
}
