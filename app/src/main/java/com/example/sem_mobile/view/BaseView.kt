package com.example.sem_mobile.view

import androidx.annotation.StringRes

interface BaseView {

    fun showError(@StringRes errorResource: Int)

    fun showProgress()

    fun hideProgress()
}