package com.example.implicitandexplicitintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.LoginBtn).setOnClickListener{OtherActivity()}

    }

    public fun OtherActivity(){
        val intent = Intent(this, OtherActivity::class.java)

        startActivity(intent)
    }
}
