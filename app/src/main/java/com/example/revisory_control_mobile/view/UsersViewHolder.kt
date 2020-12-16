package com.example.revisory_control_mobile.view

import android.util.Log
import android.view.View
import com.example.revisory_control_mobile.models.Schedule
import com.example.revisory_control_mobile.models.User
import kotlinx.android.synthetic.main.employee_item.view.*
import com.example.revisory_control_mobile.models.WeekDay

class UsersViewHolder(view: View): BaseViewAdapter.ViewHolder<User>(view) {
    init {
        //itemView.setOnClickListener { itemClickListener.invoke(savedData!!) }
        //itemView.addView.setOnClickListener{ itemClickListener2.invoke(savedData!!)}
    }

    override fun setContent(data: User) {
        itemView.tvFirstname.setText(data.firstname)
        itemView.tvLastname.setText(data.lastname)
        itemView.tvEmail.setText(data.userEmail)

        val workingDaysList: MutableList<String> = mutableListOf<String>()

        Log.wtf((WeekDay.values()[6].ordinal + 1).toString(), (WeekDay.values()[6].ordinal + 1).toString())

        for (day in data?.schedules!!)
            if (day.weekDayId == (WeekDay.values()[day.weekDayId!! - 1].ordinal) + 1)
                workingDaysList.add(WeekDay.values()[day.weekDayId!! - 1].name)

        if (workingDaysList.isNotEmpty()) {
            itemView.tvSchedule.setText(workingDaysList[0])
        }
    }
}