package com.example.implicitandexplicitintents

import android.app.DownloadManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CalendarContract
import android.provider.Settings
import android.widget.Button

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        findViewById<Button>(R.id.ViewWeb).setOnClickListener{getUrlFromIntent()}
       // findViewById<Button>(R.id.createContact).setOnClickListener{insertContact()}
        findViewById<Button>(R.id.settings).setOnClickListener{openSettings()}
        findViewById<Button>(R.id.downloads).setOnClickListener{goToDownloads()}
    }


    public fun goToDownloads() {
            startActivity(Intent(DownloadManager.ACTION_VIEW_DOWNLOADS));
    }

    public fun getUrlFromIntent() {
        val url = "http://www.google.com"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    public fun openSettings(){
        startActivity(Intent(Settings.ACTION_SETTINGS))
    }



}