package com.mjtech.calculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        //load animation (slide-in)
        val slideInAnimation = android.view.animation.AnimationUtils.loadAnimation(this, R.anim.fade_in)

        //set animation to splash screen img
        findViewById<ImageView>(R.id.appLogo).startAnimation(slideInAnimation)

        //Time delay for 3 sec
       Handler(Looper.getMainLooper()).postDelayed({
           val intent = Intent(this, MainActivity::class.java)
           startActivity(intent)
           finish()
       },3000)
    }
}