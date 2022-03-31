package com.example.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.login.SignUp
import com.example.login.databinding.ActivityLoginBinding
import com.example.login.viewmodel.MainViewModel

class Login : AppCompatActivity() {

    //MVVM
    val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityLoginBinding
    //private var edtEmail: EditText? = null
    //private var edtPassWord: EditText? = null
    //private var btnLogin: TextView? = null
    //private var txtSignUp: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_login)
        //edtEmail = findViewById<View>(R.id.edtEmail) as EditText
        //edtPassWord = findViewById<View>(R.id.edtPassWord) as EditText
        //btnLogin = findViewById<View>(R.id.btnLogin) as TextView
        //txtSignUp = findViewById<View>(R.id.txtSignUp) as TextView

        binding=DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.btnLogin?.setOnClickListener(View.OnClickListener {

            val email = binding.edtEmail?.text.toString().trim()
            val password = binding.edtPassWord?.text.toString().trim()
            Log.d("iii", email)
            Log.d("iii", password)

            mainViewModel.LoginUser(email, password)
        })

        binding.txtSignUp?.setOnClickListener(View.OnClickListener {
            val intent2 = Intent(this@Login, SignUp::class.java)
            intent2.flags = (Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent2)
            finish()
        })
        listennerSuccessEvent()
        listennerErrorEvent()
    }

    private fun listennerSuccessEvent() {
        mainViewModel.isSuccessEvent.observe(this) { isSuccess ->
            if (isSuccess) {

                val email = binding.edtEmail?.text.toString().trim()
                val password = binding.edtPassWord?.text.toString().trim()
                Log.d("iii", email)
                Log.d("iii", password)


                intent.flags = (Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        or Intent.FLAG_ACTIVITY_NEW_TASK)
                val intent = intent
                val bundle = intent.getBundleExtra("Data")
                val emailBundle = bundle?.getString("email")
                val passwordBundle = bundle?.getString("pass")
                val fullNameBundle = bundle?.getString("name")

                val EMAIL = emailBundle
                val PASS = passwordBundle

                if (email != EMAIL) {
                    Toast.makeText(this@Login, "Email is invalid", Toast.LENGTH_LONG).show()
                    return@observe
                }
                if (password != PASS) {
                    Toast.makeText(this@Login, "Pass is invalid", Toast.LENGTH_LONG).show()
                    return@observe
                }

                val intent2 = Intent(this@Login, RecycleviewDataStore::class.java)
//                val bundle2 = Bundle()
//                bundle2.putString("email", email)
//                bundle2.putString("name", fullNameBundle)
//                intent2.putExtra("Data", bundle2)
                startActivity(intent2)
            }
        }
    }

    private fun listennerErrorEvent() {
        mainViewModel.isErrorEvent.observe(this) { isError ->
            Toast.makeText(this, isError, Toast.LENGTH_LONG).show()
        }
    }
}

