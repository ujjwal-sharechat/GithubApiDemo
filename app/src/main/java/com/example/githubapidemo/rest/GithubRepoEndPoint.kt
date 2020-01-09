package com.example.githubapidemo.rest

import com.example.githubapidemo.model.GitHubUsers
import com.example.githubapidemo.model.GithubRepo
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubRepoEndPoint {

    @GET("/users/{user}/repos")
    fun getRepo(@Path("user")  name :String) : Single<List<GithubRepo>>;
}