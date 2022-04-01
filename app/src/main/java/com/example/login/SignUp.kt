package com.example.login

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.login.databinding.ActivitySignupBinding
import com.example.login.viewmodel.MainViewModel


class SignUp : AppCompatActivity() {

    //MVVM
    private lateinit var binding: ActivitySignupBinding
    val mainViewModel: MainViewModel by viewModels()

//    private var edtFullName: EditText? = null
//    private var edtEmail: EditText? = null
//    private var edtPassWord: EditText? = null
//    private var login: TextView? = null
//    private var txtLogin: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)

//        edtFullName = findViewById<View>(R.id.edtFullName) as EditText
//        edtEmail = findViewById<View>(R.id.edtEmail) as EditText
//        edtPassWord = findViewById<View>(R.id.edtPassWord) as EditText
//        txtLogin = findViewById<View>(R.id.txtLogin) as TextView
//        login = findViewById<View>(R.id.login) as TextView

        binding.login.setOnClickListener(View.OnClickListener {

            val email = binding.edtEmail.text.toString().trim()
            val password = binding.edtPassWord.text.toString().trim()
            val fullname = binding.edtFullName.text.toString().trim()
            var view : View? = null

            when {
                fullname.isEmpty() ->
                {
                    binding.edtFullName.error = "Field is required"
                    view = binding.edtFullName
                }
                email.isEmpty() ->
                {
                    binding.edtEmail.error = "Field is required"
                    view = binding.edtEmail
                }
                password.isEmpty() ->
                {
                    binding.edtPassWord.error = "Field is required"
                    view = binding.edtPassWord
                }
                Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    binding.edtEmail.error = "Field is required"
                    view = binding.edtEmail
                }
                password.length < 9 ->
                {
                    binding.edtPassWord.error = "Field is required minimum is 8"
                    view = binding.edtPassWord
                }

            }

            mainViewModel.registerUser(email, password, fullname)
        })

        binding.txtLogin?.setOnClickListener(View.OnClickListener {
            val intent2 = Intent(this@SignUp, Login::class.java)
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
                val email = binding.edtEmail.text.toString().trim()
                val password = binding.edtPassWord.text.toString().trim()
                val fullname = binding.edtFullName.text.toString().trim()

                val intent = Intent(this, Login::class.java)
                val bundle = Bundle()
                intent.flags = (Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        or Intent.FLAG_ACTIVITY_NEW_TASK)
                bundle.putString("name", fullname)
                bundle.putString("email", email)
                bundle.putString("pass", password)
                intent.putExtra("Data", bundle)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun listennerErrorEvent() {
        mainViewModel.isErrorEvent.observe(this) { isError ->
            Toast.makeText(this, isError, Toast.LENGTH_LONG).show()
        }
    }
}