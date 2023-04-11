package com.example.globaltour.qestions


import com.google.firebase.database.PropertyName
import java.io.Serializable
@kotlinx.serialization.Serializable

data class Question(
     var questionName: String ="", var username: String="" ) {

    constructor() : this("", "")
   // @set:PropertyName("email") @get:PropertyName("email") var emailPerson: String = ""

}
