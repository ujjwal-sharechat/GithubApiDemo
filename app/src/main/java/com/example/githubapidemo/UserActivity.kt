package com.example.githubapidemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.githubapidemo.model.GitHubUsers
import com.example.githubapidemo.rest.ApiClient
import com.example.githubapidemo.rest.GithubUserEndpoint
import kotlinx.android.synthetic.main.activity_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class UserActivity : AppCompatActivity() {

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

        loadata()
    }



    private fun loadata() {
        val apiservice : GithubUserEndpoint = ApiClient.getClient()!!.create(GithubUserEndpoint::class.java)
        var call : Call<GitHubUsers> = apiservice.getUser(newstring)
        Log.d("username",newstring)

        call.enqueue(object : Callback<GitHubUsers> {
           override fun onFailure(call: Call<GitHubUsers>, t: Throwable) {

            println("Failed"+t.toString())
           }

           override fun onResponse(call: Call<GitHubUsers>, response: Response<GitHubUsers>) {

//               Log.d("url",response.body()?.avatar.toString())

               Glide.with(this@UserActivity).load(response.body()?.avatar).into(avatar)

               if(response.body()?.name==null)
                   username.text= "No name"
               else
                   username.text="Username : ${response.body()?.name}"

               Log.d("username", username.text as String)

               followers.text = "Followers : ${response.body()?.followers}"

               following.text="Followings : ${response.body()?.following}"

               logIn.text="Login : ${response.body()?.login}"

               if(response.body()?.email==null)
                   email.text= "No email"
               else
                   email.text="Username : ${response.body()?.email}"

           }

       })
    }

}
