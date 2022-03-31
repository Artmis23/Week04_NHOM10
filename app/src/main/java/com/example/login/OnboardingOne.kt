package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.RelativeLayout

class OnboardingOne : AppCompatActivity() {
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_one)

        val buttonSkip = findViewById<RelativeLayout>(R.id.nut1)
        buttonSkip.setOnClickListener() {
            val intent: Intent = Intent(this, OnboardingTwo::class.java)
            startActivity(intent)
            finish()
        }
    }

}
