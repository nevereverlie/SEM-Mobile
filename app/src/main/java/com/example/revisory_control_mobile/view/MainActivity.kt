package com.example.revisory_control_mobile.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.revisory_control_mobile.R
import com.example.revisory_control_mobile.presenter.MainPresenter
import com.example.revisory_control_mobile.repository.ApiService

class MainActivity : BaseActivity<MainActivity, MainPresenter>() {

    override val layoutResId = R.layout.activity_main
    override val presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        ApiService.token = getSharedPreferences(
            "myPrefs",
            Context.MODE_PRIVATE
        ).getString("token", "").toString()
    }
}