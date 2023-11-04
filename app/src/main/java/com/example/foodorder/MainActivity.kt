package com.example.foodorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnItemSelectedListener(navigationListener)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, MenuFragment())
            .commit()
    }

    private val navigationListener = NavigationBarView.OnItemSelectedListener { item ->
        when (item.itemId) {
            R.id.menu -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, MenuFragment())
                    .commit()
                true
            }

            R.id.profile -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, ProfileFragment())
                    .commit()
                true
            }

            R.id.basket -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, BasketFragment())
                    .commit()
                true
            }

            else -> false
        }
    }
}