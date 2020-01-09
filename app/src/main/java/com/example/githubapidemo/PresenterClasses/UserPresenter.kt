package com.example.githubapidemo.PresenterClasses

import Present.Contract
import android.util.Log

import com.example.githubapidemo.model.GitHubUsers
import com.example.githubapidemo.rest.ApiClient
import com.example.githubapidemo.rest.GithubUserEndpoint

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserPresenter(private val view: Contract.Viewinterface?) : Contract.Presenter {
    override fun fetchdata(newstring:String) {


        val apiservice : GithubUserEndpoint = ApiClient.getClient().create(
            GithubUserEndpoint::class.java)
        var call : Call<GitHubUsers> = apiservice.getUser(newstring)
        Log.d("username",newstring)

        call.enqueue(object : Callback<GitHubUsers> {
            override fun onFailure(call: Call<GitHubUsers>, t: Throwable) {

                println("Failed"+t.toString())
            }

            override fun onResponse(call: Call<GitHubUsers>, response: Response<GitHubUsers>) {
                //       view?.setData(response.body())

//               Log.d("url",response.body()?.avatar.toString())
                response.body()?.let {
                    view?.setData(it)
                }


            }

        })




    }


}