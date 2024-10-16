package com.example.globaltour

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.globaltour.models.DevViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DevlistFragment : Fragment() {

    private lateinit var devList: ArrayList<Devprofile>
    private lateinit var recyclerView: RecyclerView
    private lateinit var devAdapter: Devdapter
    private lateinit var viewModel: DevViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_devlist, container, false)
        setUpRecyclerView(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        devList = ArrayList()

        // Initialize RecyclerView and its Adapter
        recyclerView = view.findViewById(R.id.devlist_recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)

        devAdapter = Devdapter(requireContext(), devList)
        recyclerView.adapter = devAdapter

        viewModel = ViewModelProvider(this).get(DevViewModel::class.java)
        viewModel.All_devs.observe(viewLifecycleOwner, Observer {
            devList.clear()
            devList.addAll(it)
            devAdapter.notifyDataSetChanged()
        })
    }
    private fun setUpRecyclerView(view: View) {
        devList = ArrayList() // Initialize devList to prevent any null pointer exception
        devAdapter = Devdapter(requireContext(), devList) // Initialize devAdapter before use

        recyclerView = view.findViewById(R.id.devlist_recycler) // Ensure this is the correct ID
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = devAdapter // Assign devAdapter to RecyclerView

        // Firebase database reference to fetch data
        val docRef = FirebaseDatabase.getInstance().getReference("devprofile")
        docRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                devList.clear() // Clear the list to avoid duplicate entries
                for (devprofileSnapshot in snapshot.children) {
                    val devprofile = devprofileSnapshot.getValue(Devprofile::class.java)
                    devprofile?.let {
                        devList.add(it)
                    }

                }



            devAdapter.notifyDataSetChanged() // Notify adapter about data changes
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireActivity(), "Error retrieving data", Toast.LENGTH_SHORT).show()
            }
        })
    }


}
