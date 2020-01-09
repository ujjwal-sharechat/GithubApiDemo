package com.example.githubapidemo.model

import com.google.gson.annotations.SerializedName

data class GithubRepo(@SerializedName("name") val name:String,@SerializedName("description") val description:String,@SerializedName("language") val language:String) {


}