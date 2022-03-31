package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import com.example.login.R

class Welcome : AppCompatActivity() {
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        handler = Handler()
        val buttonSkip  = findViewById<Button>(R.id.skip)
        buttonSkip.setOnClickListener(){
            val intent: Intent = Intent(this, SignUp::class.java)
            startActivity(intent)
            finish()
        }
        val buttonStartWith = findViewById<Button>(R.id.button3)
        buttonStartWith.setOnClickListener(){
            val intent: Intent = Intent(this, SignUp::class.java)
            startActivity(intent)
            finish()
        }

        val buttonSignIn = findViewById<Button>(R.id.signin)
        buttonSignIn.setOnClickListener(){
            val intent: Intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }
    }
}