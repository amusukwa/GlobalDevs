package com.example.globaltour.repository

import androidx.lifecycle.MutableLiveData
import com.example.globaltour.Devprofile
import com.google.firebase.database.*

class DevProfileRepository {
    private   val databaseReference: DatabaseReference =  FirebaseDatabase.getInstance()
        .getReference("questions")
    @Volatile  private var INSTANCE: DevProfileRepository?= null
    fun getInstance(): DevProfileRepository {
        return INSTANCE?: synchronized(this){
            val instance = DevProfileRepository()
            INSTANCE = instance
            instance
        }
    }

    fun loadDevs(devsList: MutableLiveData<List<Devprofile>>){
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val _devsList : List<Devprofile> = snapshot.children.map { dataSnapshot ->
                        dataSnapshot.getValue(Devprofile::class.java)!!
                    }
                    devsList.postValue(_devsList)
                } catch (e : Exception){}
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

}