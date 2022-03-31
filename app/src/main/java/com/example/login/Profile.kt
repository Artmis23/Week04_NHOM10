package com.example.login

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.example.login.databinding.ActivityProfileBinding
import com.example.login.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Profile : AppCompatActivity() {

    //MVVM
    val mainViewModel: MainViewModel by viewModels()
    lateinit var dataBinding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_profile)

        dialogProfile()
        getDataFromSignUp();
    }

    private fun getDataFromSignUp() {
        val intent2 = intent
        val bundle2 = intent.getBundleExtra("Data")
        val fullNameBundle = bundle2?.getString("name")
        val emailBundle = bundle2?.getString("email")

        dataBinding.txtFullName?.setText(fullNameBundle)
        dataBinding.txtEmail?.setText(emailBundle)

    }

    private fun dialogProfile() {

        dataBinding.txtFullName?.setOnClickListener(View.OnClickListener { view ->
            val builder = AlertDialog.Builder(this@Profile)
            val viewGroup = findViewById<ViewGroup>(android.R.id.content)

            val dialogView =
                LayoutInflater.from(view.context)
                    .inflate(R.layout.dialog_signup_fullname, viewGroup, false)
            builder.setView(dialogView)
            val alertDialog = builder.create()
            alertDialog.show()

            val edtDialogFullName = alertDialog.findViewById<EditText>(R.id.edtDialogFullName)
            val txtDialogCancelFullName =
                alertDialog.findViewById<TextView>(R.id.txtDialogCancelFullName)
            val btnDialogEnterFullName =
                alertDialog.findViewById<TextView>(R.id.btnDialogEnterFullName)

            txtDialogCancelFullName.setOnClickListener {
                alertDialog.dismiss()
            }

            btnDialogEnterFullName.setOnClickListener {
                val fullName: String = edtDialogFullName.getText().toString().trim { it <= ' ' }
                dataBinding.txtFullName?.setText(fullName)
                alertDialog.cancel()
            }
        })



        dataBinding.txtEmail?.setOnClickListener(View.OnClickListener { view ->
            val builder = AlertDialog.Builder(this@Profile)
            val viewGroup = findViewById<ViewGroup>(android.R.id.content)

            val dialogView =
                LayoutInflater.from(view.context)
                    .inflate(R.layout.dialog_signup_email, viewGroup, false)
            builder.setView(dialogView)
            val alertDialog = builder.create()
            alertDialog.show()

            val edtDialogEmail = alertDialog.findViewById<EditText>(R.id.edtDialogEmail)
            val txtDialogCancelEmail =
                alertDialog.findViewById<TextView>(R.id.txtDialogCancelEmail)
            val btnDialogEnterEmail =
                alertDialog.findViewById<TextView>(R.id.btnDialogEnterEmail)

            txtDialogCancelEmail.setOnClickListener {
                alertDialog.dismiss()
            }

            btnDialogEnterEmail.setOnClickListener {
                val email: String = edtDialogEmail.getText().toString().trim { it <= ' ' }
                dataBinding.txtEmail?.setText(email)
                alertDialog.cancel()
            }
        })


        dataBinding.txtPhone?.setOnClickListener(View.OnClickListener { view ->
            val builder = AlertDialog.Builder(this@Profile)
            val viewGroup = findViewById<ViewGroup>(android.R.id.content)

            val dialogView =
                LayoutInflater.from(view.context)
                    .inflate(R.layout.dialog_signup_password, viewGroup, false)
            builder.setView(dialogView)
            val alertDialog = builder.create()
            alertDialog.show()

            val edtDialogPassword = alertDialog.findViewById<EditText>(R.id.edtDialogPassword)
            val txtDialogCancelPassword =
                alertDialog.findViewById<TextView>(R.id.txtDialogCancelPassword)
            val btnDialogEnterPassword =
                alertDialog.findViewById<TextView>(R.id.btnDialogEnterPassword)

            txtDialogCancelPassword.setOnClickListener {
                alertDialog.dismiss()
            }

            btnDialogEnterPassword.setOnClickListener {
                val password: String = edtDialogPassword.getText().toString().trim { it <= ' ' }
                dataBinding.txtPhone?.setText(password)
                alertDialog.cancel()
            }
        })
    }
}