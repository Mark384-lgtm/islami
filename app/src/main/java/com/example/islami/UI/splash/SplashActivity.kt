package com.example.islami.UI.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.R
import com.example.islami.UI.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        val iv_splashScreen: ImageView = findViewById(R.id.splashScreen)
        iv_splashScreen.setImageResource(R.drawable.group8)

        val intent: Intent = Intent(this, HomeActivity::class.java)

        val run: Boolean = Handler(Looper.getMainLooper()).postDelayed(object : Runnable {
            override fun run() {
                startActivity(intent)
                finish()
            }
        }, 1000)


    }


}