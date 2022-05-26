package com.example.sem_mobile.presenter

import android.util.Log
import com.example.sem_mobile.models.User
import com.example.sem_mobile.repository.UserRepository
import com.example.sem_mobile.view.ProfileActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ProfilePresenter : BasePresenter<ProfileActivity>() {

    private val userRepository = UserRepository()

    private lateinit var currentUser: User

    private var currentUserId: Int = -1

    fun loadUserData(id: Int) {
        currentUserId = id

        userRepository
            .getUserById(currentUserId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onUserLoaded, ::onError)
    }

    private fun onUserLoaded(user: User) {
        //Log.wtf("FNP", "User loaded: name: ${user.lastname}")

        view?.showUserInfo(user)
    }

}