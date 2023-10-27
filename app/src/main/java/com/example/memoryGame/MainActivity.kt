package com.example.memoryGame

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.text.HtmlCompat
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.memmorygame.R
import com.example.memmorygame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var actionBarDrawerToggle: ActionBarDrawerToggle? = null
    private var navHostFragment: NavHostFragment? = null
    private var navigationController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        navigationController = navHostFragment!!.navController


        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, binding.rootView, binding.toolbar,R.string.nav_open, R.string.nav_close)
        binding.rootView.addDrawerListener(actionBarDrawerToggle!!)
        actionBarDrawerToggle?.syncState()
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        navigationController!!.addOnDestinationChangedListener(NavController.OnDestinationChangedListener {
                _, destination, _ ->

            if (destination.id == R.id.splashFragment) {
                binding.toolbar.visibility = View.GONE
            } else {
                binding.toolbar.visibility = View.VISIBLE
            }
        })

        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.about ->{
                    customDialog()
                    binding.rootView.closeDrawer(GravityCompat.START)
                }
            }

                return@setNavigationItemSelectedListener true
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle?.onOptionsItemSelected(item) == true) {
            return true
        }

        return super.onOptionsItemSelected(item);
    }

    private fun customDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.custome_dialog)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.setCancelable(false)

        val txtDis: TextView = dialog.findViewById<TextView>(R.id.txtDis)
        val btnOk: Button = dialog.findViewById<Button>(R.id.btnOk)


        txtDis.text = HtmlCompat.fromHtml("<big><b><font color = \"#FFFFFF\">Memory Game</font></b></big><font color=\"#FFFFFF\"><small>A game is a structured form of play, usually undertaken" +
                " for entertainment or fun, and sometimes used as an educational tool.</small></font>",
            HtmlCompat.FROM_HTML_MODE_LEGACY)

        btnOk.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}
