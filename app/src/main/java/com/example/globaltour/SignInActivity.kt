package com.example.globaltour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class SignInActivity : AppCompatActivity() {

    private val RC_SIGN_IN: Int = 1
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var mGoogleSignInOptions: GoogleSignInOptions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val signIn :Button = findViewById(R.id.google_button)
        // Configure Google Sign-In
        mGoogleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, mGoogleSignInOptions)

//        // Set onClickListener for sign-in button
//        sign_in_button.setOnClickListener {
//            signIn()
//        }
}
    private fun signIn() {
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = FirebaseAuth.getInstance().signInWithCredential(GoogleAuthProvider.getCredential(data?.data.toString(), null))
            task.addOnCompleteListener { signInTask ->
                if (signInTask.isSuccessful) {
                    // Sign in success
                    val user = FirebaseAuth.getInstance().currentUser
                    // Handle successful sign-in (e.g., navigate to the main activity)
                } else {
                    // Sign in failed
                    // Handle sign-in failure (e.g., display an error message)
                }
            }
        }
    }


}