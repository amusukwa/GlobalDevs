package com.example.globaltour.qestions

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable
@kotlinx.serialization.Serializable

data class Question(
    private val questionName: String ="", val username: String="" ) {

    constructor() : this("", "")
}
