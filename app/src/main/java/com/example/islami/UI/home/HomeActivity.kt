package com.example.islami.UI.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.UI.home.hadith.HadithFragment
import com.example.islami.UI.home.quran.QuranFragmnet
import com.example.islami.UI.home.radio.RadioFragmnet
import com.example.islami.UI.home.tasbih.TasbihFragmnet
import com.example.islami.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    //lateinit var bottom_nav:BottomNavigationView
    lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // bottom_nav=findViewById(R.id.navigation_home)


        binding.content.navigationHome.setOnItemSelectedListener {
            if (it.itemId == R.id.navigation_quran) {
                showTab(QuranFragmnet())
            } else if (it.itemId == R.id.navigation_tasbih) {
                showTab(TasbihFragmnet())
            } else if (it.itemId == R.id.navigation_radio) {
                showTab(RadioFragmnet())
            } else if (it.itemId == R.id.navigation_hadith) {
                showTab(HadithFragment())
            }

            return@setOnItemSelectedListener true
        }
        binding.content.navigationHome.selectedItemId = R.id.navigation_quran


    }

    fun showTab(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

}
