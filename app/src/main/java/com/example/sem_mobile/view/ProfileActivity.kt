package com.example.sem_mobile.view

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.sem_mobile.R
import com.example.sem_mobile.models.User
import com.example.sem_mobile.models.WeekDay
import com.example.sem_mobile.presenter.ProfilePresenter
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.employee_item.view.*

class ProfileActivity : BaseActivity<ProfileActivity, ProfilePresenter>() {

    override val layoutResId = R.layout.activity_profile

    override val presenter = ProfilePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ivEmployees.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnLogout.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            builder.setTitle(getString(R.string.logout_dialog_title))

            builder.setMessage(getString(R.string.logout_dialog_message))

            builder.setPositiveButton(getString(R.string.logout_dialog_btn_positive)){dialog, which ->
                val sharedPref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putInt("userId", -1)
                    apply()
                }

                val intent = Intent(this, SignInActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)

                Toast.makeText(applicationContext,getString(R.string.logout_dialog_success),Toast.LENGTH_SHORT).show()
            }

            builder.setNegativeButton(getString(R.string.logout_dialog_btn_negative)){dialog,which -> }

            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

        presenter.loadUserData(
            getSharedPreferences(
                "myPrefs",
                Context.MODE_PRIVATE
            ).getInt("userId", -1)
        )
    }

    fun showUserInfo(user: User) {
        etFirstname.setText(user.firstname)
        etLastname.setText(user.lastname)
        etDepartment.setText(user.department?.departmentName)
        etEmail.setText(user.userEmail)

        val workingDaysList: MutableList<String> = mutableListOf<String>()

        for (day in user?.schedules!!)
            if (day.weekDayId == (WeekDay.values()[day.weekDayId!! - 1].ordinal) + 1)
                workingDaysList.add(WeekDay.values()[day.weekDayId!! - 1].printName())

        if (workingDaysList.isNotEmpty()) {
            etSchedule.setText(workingDaysList.joinToString { day -> "$day" })
        }

    }
}