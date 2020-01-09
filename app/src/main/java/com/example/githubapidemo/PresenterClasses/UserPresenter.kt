package com.example.githubapidemo.PresenterClasses

import Present.Contract
import android.util.Log

import com.example.githubapidemo.model.GitHubUsers
import com.example.githubapidemo.rest.ApiClient
import com.example.githubapidemo.rest.GithubUserEndpoint
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserPresenter(private val view: Contract.Viewinterface?) : Contract.Presenter {
    override fun fetchdata(newstring:String) {


        val apiservice : GithubUserEndpoint = ApiClient.getClient().create(
            GithubUserEndpoint::class.java)
        val s = apiservice.getUser(newstring)
        Log.d("username",newstring)

        s.observeOn(AndroidSchedulers.mainThread()).doOnSuccess {
                view?.setData(it)


        }.doOnError {
            Log.e("GetUser","Failed $it")
        }.subscribe()




//        call.enqueue(object : Callback<GitHubUsers> {
//            override fun onFailure(call: Call<GitHubUsers>, t: Throwable) {
//
//                println("Failed"+t.toString())
//            }
//
//            override fun onResponse(call: Call<GitHubUsers>, response: Response<GitHubUsers>) {
//                //       view?.setData(response.body())
//
//               Log.d("url",response.body()?.avatar.toString())
//                response.body()?.let {
//                    view?.setData(it)
//                }
//
//
//            }
//
//        })




    }


}