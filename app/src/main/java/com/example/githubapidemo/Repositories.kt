package com.example.githubapidemo

import Present.ContractRepo
import adapter.ReposAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubapidemo.PresenterClasses.RepoPresenter
import com.example.githubapidemo.PresenterClasses.UserPresenter
import com.example.githubapidemo.model.GitHubUsers
import com.example.githubapidemo.model.GithubRepo
import com.example.githubapidemo.rest.ApiClient
import com.example.githubapidemo.rest.GithubRepoEndPoint
import com.example.githubapidemo.rest.GithubUserEndpoint
import kotlinx.android.synthetic.main.activity_repositories.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repositories : AppCompatActivity(),ContractRepo.RepoInterface {


    lateinit var recievedusername : String
    private var mdatasource  = ArrayList<GithubRepo>()
    private var mAdapter: ReposAdapter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repositories)

        intent.extras?.let {
            recievedusername = it.getString("username").toString()
        }
        userNameTV.text= "USER : $recievedusername"

       // loadrepositories()


        val userobject = RepoPresenter(this)

        userobject.fetchdata(recievedusername)

    repos_recycler_view.layoutManager = LinearLayoutManager(this)
        mAdapter = ReposAdapter(mdatasource)
        repos_recycler_view.adapter= mAdapter



    }

//    fun loadrepositories()
//    {
//        val apiservice : GithubRepoEndPoint = ApiClient.getClient()!!.create(GithubRepoEndPoint::class.java)
//
//        var call : Call<List<GithubRepo>> = apiservice.getRepo(recievedusername)
//
//        call.enqueue(object : Callback<List<GithubRepo>> {
//            override fun onFailure(call: Call<List<GithubRepo>>, t: Throwable) {
//                Log.d("repos",t.toString())
//            }
//
//            override fun onResponse(call: Call<List<GithubRepo>>, response: Response<List<GithubRepo>>) {
//                mdatasource.clear()
//                response.body()?.let {
//                    mdatasource.addAll(it)
//                    mAdapter?.update(mdatasource)
//                }
//
//                repos_recycler_view.adapter?.notifyDataSetChanged()
//            }
//
//        })
//
//    }

    override fun setdata(mdatasource: ArrayList<GithubRepo>) {
        mAdapter?.update(mdatasource)
        repos_recycler_view.adapter?.notifyDataSetChanged()
    }


}
