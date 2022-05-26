package com.example.sem_mobile.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.sem_mobile.R
import com.example.sem_mobile.models.User

class UsersAdapter() : BaseViewAdapter<User>() {

    override fun getViewHolderByViewType(
        inflater: LayoutInflater,
        viewType: Int,
        parent: ViewGroup
    ) =
        UsersViewHolder(
            inflater.inflate(R.layout.employee_item, parent, false)
        )
}