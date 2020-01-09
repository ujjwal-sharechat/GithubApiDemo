package com.example.githubapidemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener{ v ->
            intent = Intent(this, UserActivity::class.java)
            intent.putExtra("username_string",input_username.text.toString())
            Log.d("username",input_username.text.toString())
            startActivity(intent)
        }
    }
}
