package com.example.bottom_nav_complete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.bottom_nav_complete.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setfragment(Home())

        binding.bottomNavigationView.setOnItemSelectedListener(this)



    }
    fun setfragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.framelayout,fragment).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.profile->{setfragment(Profile())}
            R.id.feeds->{setfragment(Feeds())}
            R.id.settings->{setfragment(Settings())}
            R.id.home->{setfragment(Home())}
        }
        return true
    }
}