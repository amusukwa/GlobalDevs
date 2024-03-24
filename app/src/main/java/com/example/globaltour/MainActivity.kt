package com.example.globaltour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar        : Toolbar
    private lateinit var navController  : NavController
    private lateinit var bottomNavView  : BottomNavigationView
    private lateinit var auth: FirebaseAuth
    private lateinit var authStateListener: FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Views
        toolbar         = findViewById(R.id.activity_main_toolbar)
        bottomNavView   = findViewById(R.id.bottom_nav_view)
        auth = FirebaseAuth.getInstance()


        // Get NavHostFragment and NavController
        val navHostFrag = supportFragmentManager.findFragmentById(R.id.nav_host_frag) as NavHostFragment
        navController   = navHostFrag.navController

        // Define AppBarConfiguration
        val topLevelDestinations = setOf(R.id.fragmentCityList, R.id.fragmentFavoriteList)
        val appBarConfiguration = AppBarConfiguration(topLevelDestinations)

        // Connect Toolbar with NavController
        toolbar.setupWithNavController(navController, appBarConfiguration)

        // Connect BottomNavigationView with NavController
        bottomNavView.setupWithNavController(navController)
    }

    override fun onStart() {
        super.onStart()
        val authStateListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            val currentUser = FirebaseAuth.getInstance().currentUser
            if (currentUser == null) {
                // If user is not signed in, navigate to sign-in activity
                startActivity(Intent(this, SignInActivity::class.java))
                finish() // Finish MainActivity to prevent user from going back

            }}
        // Add authentication state listener when the activity starts
        auth.addAuthStateListener(authStateListener)
    }


    override fun onStop() {
        super.onStop()
        // Remove authentication state listener when the activity stops
        auth.removeAuthStateListener(authStateListener)
    }


}
