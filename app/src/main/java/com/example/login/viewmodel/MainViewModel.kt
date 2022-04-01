package com.example.login.viewmodel

import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class Resp(val isSuccess: Boolean, val error: Error?)
class MainViewModel : ViewModel() {

    private var _isSuccessEvent: MutableLiveData<Boolean> = MutableLiveData()
    val isSuccessEvent: LiveData<Boolean>
        get() = _isSuccessEvent

    private var _isErrorEvent: MutableLiveData<String> = MutableLiveData()
    val isErrorEvent: LiveData<String>
        get() = _isErrorEvent

    var job: Job? = null

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

    fun abc() {

    }
    fun registerUser(email: String, passWord: String, fullName: String) {
        val isValidEmail = isEmailValid(email)
        if (!isValidEmail) {
            _isErrorEvent.postValue("email không hợp lệ")
            return
        }

        val isValidPassword = isPasswordValid(passWord)
        if (!isValidPassword) {
            _isErrorEvent.postValue("password không hợp lệ")
            return
        }

        val isFullnameValid = isFullnameValid(fullName)
        if (!isFullnameValid) {
            _isErrorEvent.postValue("Fullname không hợp lệ")
            return
        }

        _isSuccessEvent.postValue(true)
    }

    fun LoginUser(email: String, passWord: String) {
        val isValidEmail = isEmailValid(email)
        if (!isValidEmail) {
            _isErrorEvent.postValue("email không hợp lệ")
            return
        }

        val isValidPassword = isPasswordValid(passWord)
        if (!isValidPassword) {
            _isErrorEvent.postValue("password không hợp lệ")
            return
        }
        _isSuccessEvent.postValue(true)
    }



    private fun isEmailValid(emailFun: String): Boolean {
        return !TextUtils.isEmpty(emailFun)
                && android.util.Patterns.EMAIL_ADDRESS.matcher(emailFun).matches()
    }

    private fun isPasswordValid(passWordFun: String): Boolean {
        return !TextUtils.isEmpty(passWordFun) && passWordFun.length in 8..20
    }

    private fun isFullnameValid(fullNameFun: String): Boolean {
        return !TextUtils.isEmpty(fullNameFun)
    }

}
