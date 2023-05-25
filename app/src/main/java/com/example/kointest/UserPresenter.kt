package com.example.kointest

import com.example.kointest.Repository.UserRepository

// TODO 5: Let's write a presenter component to display a user:

class UserPresenter(private val repository: UserRepository) {

    fun sayHello(name : String) : String{
        val foundUser = repository.findUser(name)
        return foundUser?.let { "Hello '$it' from $this" } ?: "User '$name' not found!"
    }
}