package com.example.githubapidemo.rest

import com.example.githubapidemo.model.GitHubUsers
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path



interface GithubUserEndpoint {
    @GET("/users/{user}")
    fun getUser(@Path("user")  user :String) : Call <GitHubUsers>;
}