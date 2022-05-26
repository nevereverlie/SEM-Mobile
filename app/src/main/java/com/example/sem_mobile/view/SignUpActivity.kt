package com.example.sem_mobile.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Toast
import com.example.sem_mobile.R
import com.example.sem_mobile.presenter.SignUpPresenter
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity() : BaseActivity<SignUpActivity, SignUpPresenter>(), Parcelable {

    override val presenter = SignUpPresenter()

    override val layoutResId = R.layout.activity_sign_up

    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btnSignUp.setOnClickListener {
            presenter.onSignUpClicked(
                tvRegisterEmail.text.toString(),
                tvRegisterPassword.text.toString(),
                tvRegisterFirstname.text.toString(),
                tvRegisterLastname.text.toString()
            )
        }

        tvSignIn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }

    fun onSigUpError() {
        Toast.makeText(this, "Користувач з такими даними вже існує!", Toast.LENGTH_LONG).show()
    }
    fun emptyError() {
        Toast.makeText(this, "Будь ласка, заповніть всі поля", Toast.LENGTH_LONG).show()
    }

    fun onSignUpSuccess(userId: Int, token: String) {
        val sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putInt("userId", userId)
            putString("token", token)
            apply()
        }

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SignUpActivity> {
        override fun createFromParcel(parcel: Parcel): SignUpActivity {
            return SignUpActivity(parcel)
        }

        override fun newArray(size: Int): Array<SignUpActivity?> {
            return arrayOfNulls(size)
        }
    }
}