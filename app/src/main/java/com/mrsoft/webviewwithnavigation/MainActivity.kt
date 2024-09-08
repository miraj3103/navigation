package com.mrsoft.webviewwithnavigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.mrsoft.webviewwithnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navcontroller : NavController
    lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar.root)
        val drawerLayout = binding.drawerLayout
        val navigation = binding.navigationView

        navcontroller = findNavController(R.id.fragmentContainerView)
        appBarConfiguration = AppBarConfiguration(

            setOf(
                R.id.home,
                R.id.bitCoin,
            ),drawerLayout
        )

    setupActionBarWithNavController(navcontroller,drawerLayout)
        navigation.setupWithNavController(navcontroller)

    }
    override fun onSupportNavigateUp(): Boolean {
        return navcontroller.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}