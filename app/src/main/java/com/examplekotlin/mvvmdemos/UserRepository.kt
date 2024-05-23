package com.examplekotlin.mvvmdemos

class UserRepository {
    suspend fun getUsers(): List<User> {
        return RetrofitInstance.api.getUsers()
    }

}
