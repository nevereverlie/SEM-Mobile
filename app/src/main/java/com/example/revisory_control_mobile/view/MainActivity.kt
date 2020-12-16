package com.example.revisory_control_mobile.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.revisory_control_mobile.R
import com.example.revisory_control_mobile.models.User
import com.example.revisory_control_mobile.presenter.MainPresenter
import com.example.revisory_control_mobile.repository.ApiService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainActivity, MainPresenter>() {

    override val layoutResId = R.layout.activity_main
    override val presenter = MainPresenter()
    private val adapter = UsersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ApiService.token = getSharedPreferences(
            "myPrefs",
            Context.MODE_PRIVATE
        ).getString("token", "").toString()

        initRvEmployees()
    }

    private fun initRvEmployees() {
        rvEmployeesList.adapter = adapter
        presenter.loadUsers()
    }

    fun showEmployees(users: List<User>) {
        adapter.updateList(users)
    }

    fun usersLoadError() {
        Toast.makeText(this, "Не вдалося завантажити список працівників...",
            Toast.LENGTH_LONG)
            .show()
    }
}