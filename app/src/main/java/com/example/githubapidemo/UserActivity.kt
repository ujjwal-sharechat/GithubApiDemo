package com.example.githubapidemo

import Present.Contract
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.githubapidemo.PresenterClasses.UserPresenter
import com.example.githubapidemo.model.GitHubUsers
import com.example.githubapidemo.rest.ApiClient
import com.example.githubapidemo.rest.GithubUserEndpoint
import kotlinx.android.synthetic.main.activity_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class UserActivity : AppCompatActivity(), Contract.Viewinterface {

    lateinit var newstring : String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        intent.extras?.let {
            newstring = it.getString("username_string").toString()
        }

        ownedReposBtn.setOnClickListener{ v ->
            intent = Intent(this, Repositories::class.java)
            intent.putExtra("username",newstring)
            startActivity(intent)
        }

        val userobject = UserPresenter(this)

        userobject.fetchdata(newstring)



      //  loadata()
    }



//    private fun loadata() {
//        val apiservice : GithubUserEndpoint = ApiClient.getClient()!!.create(GithubUserEndpoint::class.java)
//        var call : Call<GitHubUsers> = apiservice.getUser(newstring)
//        Log.d("username",newstring)
//
//        call.enqueue(object : Callback<GitHubUsers> {
//           override fun onFailure(call: Call<GitHubUsers>, t: Throwable) {
//
//            println("Failed"+t.toString())
//           }
//
//           override fun onResponse(call: Call<GitHubUsers>, response: Response<GitHubUsers>) {
//        //       view?.setData(response.body())
//
////               Log.d("url",response.body()?.avatar.toString())
//
//
//
//           }
//
//       })
//    }

    override fun setData(response: GitHubUsers) {
        Glide.with(this@UserActivity).load(response.avatar).into(avatar)

        if(response.name==null)
            username.text= "No name"
        else
            username.text="Username : ${response.name}"

        Log.d("username", username.text as String)

        followers.text = "Followers : ${response.followers}"

        following.text="Followings : ${response.following}"

        logIn.text="Login : ${response.login}"

        if(response.email==null)
            email.text= "No email"
        else
            email.text="Username : ${response.email}"
    }

}
