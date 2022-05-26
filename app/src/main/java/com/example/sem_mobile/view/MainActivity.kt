package com.example.sem_mobile.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sem_mobile.R
import com.example.sem_mobile.models.User
import com.example.sem_mobile.presenter.MainPresenter
import com.example.sem_mobile.repository.ApiService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainActivity, MainPresenter>() {

    override val layoutResId = R.layout.activity_main
    override val presenter = MainPresenter()
    private val adapter = UsersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ivProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

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