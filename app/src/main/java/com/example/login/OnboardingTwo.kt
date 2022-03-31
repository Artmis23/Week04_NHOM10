package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.RelativeLayout

class OnboardingTwo : AppCompatActivity() {
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_two)

        val buttonSkip = findViewById<RelativeLayout>(R.id.nut2)
        buttonSkip.setOnClickListener() {
            val intent: Intent = Intent(this, OnboardingThree::class.java)
            startActivity(intent)
            finish()
        }
    }

}
