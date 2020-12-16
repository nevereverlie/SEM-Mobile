package com.example.revisory_control_mobile.presenter

import com.example.revisory_control_mobile.models.User
import com.example.revisory_control_mobile.repository.UserRepository
import com.example.revisory_control_mobile.view.MainActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenter : BasePresenter<MainActivity>() {

    private val userRepository = UserRepository()

    fun loadUsers() {
        userRepository
            .getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onLoadSuccess, ::onError)
    }

    private fun onLoadSuccess(users: List<User>) {
        view?.showEmployees(users)
    }

    override fun onError(error: Throwable) {
        super.onError(error)
        view?.usersLoadError()
    }
}