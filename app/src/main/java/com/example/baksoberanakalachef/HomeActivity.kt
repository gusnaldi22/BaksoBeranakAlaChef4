package com.example.baksoberanakalachef

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        btn_about.setOnClickListener()
        {
            Intent(this@HomeActivity, AboutActivity::class.java).also {
                startActivity(it)
            }
        }
        btn_makanan.setOnClickListener()
        {
            Intent(this@HomeActivity, MakananActivity::class.java).also {
                startActivity(it)
            }
        }
        btn_minuman.setOnClickListener()
        {
            Intent(this@HomeActivity, MinumanActivity::class.java).also {
                startActivity(it)
            }
        }

    }





}

