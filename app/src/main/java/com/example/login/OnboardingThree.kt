package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.RelativeLayout

class OnboardingThree : AppCompatActivity() {
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_three)

        val buttonSkip = findViewById<RelativeLayout>(R.id.nut3)
        buttonSkip.setOnClickListener() {
            val intent: Intent = Intent(this, Welcome::class.java)
            startActivity(intent)
            finish()
        }
    }

}
