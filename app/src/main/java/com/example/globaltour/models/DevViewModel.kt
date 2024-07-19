package com.example.globaltour.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.globaltour.Devprofile
import com.example.globaltour.qestions.Question
import com.example.globaltour.repository.DevProfileRepository
import com.example.globaltour.repository.QuestionRepository

class DevViewModel: ViewModel() {
    private val repository: DevProfileRepository = DevProfileRepository().getInstance()
    private val all_devs = MutableLiveData<List<Devprofile>>()
    val All_devs : MutableLiveData<List<Devprofile>> = all_devs
    //initialization
    init {
        repository.loadDevs(all_devs)

    }
}