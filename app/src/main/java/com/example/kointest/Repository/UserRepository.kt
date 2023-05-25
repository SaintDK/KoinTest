package com.example.kointest.Repository

import com.example.kointest.User

// TODO 3: We create a "Repository"
//  component to manage the list of users (add users or find one by name).
//  Here below, the UserRepository interface and its implementation:

interface UserRepository {
    fun findUser(name : String): User?
    fun addUsers(users : List<User>)
}

class UserRepositoryImpl : UserRepository {

    private val _users = arrayListOf<User>()

    override fun findUser(name: String): User? {
        return _users.firstOrNull { it.name == name }
    }

    override fun addUsers(users : List<User>) {
        _users.addAll(users)
    }
}