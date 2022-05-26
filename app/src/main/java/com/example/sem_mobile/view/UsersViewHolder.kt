package com.example.sem_mobile.view

import android.util.Log
import android.view.View
import com.example.sem_mobile.models.User
import com.example.sem_mobile.models.WeekDay
import kotlinx.android.synthetic.main.employee_item.view.*
import java.util.*

class UsersViewHolder(view: View): BaseViewAdapter.ViewHolder<User>(view) {
    init {
        //itemView.setOnClickListener { itemClickListener.invoke(savedData!!) }
        //itemView.addView.setOnClickListener{ itemClickListener2.invoke(savedData!!)}
    }

    override fun setContent(data: User) {
        itemView.tvFirstname.setText(data.firstname)
        itemView.tvLastname.setText(data.lastname)
        itemView.tvEmail.setText(data.userEmail)
        itemView.tvDepartment.setText(data.department?.departmentName)

        val workingDaysList: MutableList<String> = mutableListOf<String>()

        for (day in data?.schedules!!)
            if (day.weekDayId == (WeekDay.values()[day.weekDayId!! - 1].ordinal) + 1)
                workingDaysList.add(WeekDay.values()[day.weekDayId!! - 1].printName())

        if (workingDaysList.isNotEmpty()) {
            itemView.etWorkingDays.setText(workingDaysList.joinToString { day -> "$day" })
        }

       Log.wtf("awdawd", Locale.getDefault().displayLanguage)

    }
}