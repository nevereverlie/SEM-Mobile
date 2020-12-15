package com.example.revisory_control_mobile.presenter

import com.example.revisory_control_mobile.models.LoginResponse
import com.example.revisory_control_mobile.repository.UserRepository
import com.example.revisory_control_mobile.view.SignUpActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SignUpPresenter : BasePresenter<SignUpActivity>() {

    private val userRepository = UserRepository()

    private var currentEmail: String = ""
    private var currentPassword: String = ""
    private var currentFirstname: String = ""
    private var currentLastname: String = ""

    fun onSignUpClicked(email: String, password: String, firstname: String, lastname: String) {
        currentEmail = email
        currentPassword = password
        currentFirstname = firstname
        currentLastname = lastname

        if (email != "" && password != "" && firstname != "" && lastname != "") {
            userRepository
                .registerUser(email, password, firstname, lastname)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onSignUpSuccess, ::onError)
        } else {
            view?.emptyError()
        }
    }

    private fun onSignUpSuccess() {
        userRepository
            .loginUser(currentEmail, currentPassword)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onLoginSuccess, ::onError)
    }

    private fun onLoginSuccess(response: LoginResponse) {
        view?.onSignUpSuccess(response.userId, response.token)
    }

    override fun onError(error: Throwable) {
        super.onError(error)
        view?.onSigUpError()
    }
}