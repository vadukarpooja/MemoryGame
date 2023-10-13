package com.example.memoryGame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.memmorygame.R
import com.example.memmorygame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var actionBarDrawerToggle: ActionBarDrawerToggle? = null
    var navHostFragment: NavHostFragment? = null
    var navigationController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        navigationController = navHostFragment!!.navController


        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, binding.rootView, binding.toolbar,R.string.nav_open, R.string.nav_close)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        navigationController!!.addOnDestinationChangedListener(NavController.OnDestinationChangedListener {
                controller, destination, _ ->

            if (destination.id == R.id.splashFragment) {
                binding.toolbar.visibility = View.GONE
            } else {
                binding.toolbar.visibility = View.VISIBLE
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle?.onOptionsItemSelected(item) == true) {
            return true
        }

        return super.onOptionsItemSelected(item);
    }
}