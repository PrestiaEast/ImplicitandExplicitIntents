package com.example.implicitandexplicitintents

import android.app.DownloadManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.ContactsContract
import android.provider.MediaStore
import android.provider.Settings
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)


  //      val username = intent.getStringExtra("")
     ///   if(username != null) {
       //     Log.i("info", username)
      //  }

        findViewById<Button>(R.id.ViewWeb).setOnClickListener{getUrlFromIntent()}
        findViewById<Button>(R.id.settings).setOnClickListener{openSettings()}
        findViewById<Button>(R.id.sms).setOnClickListener{createSMS()}
        findViewById<Button>(R.id.fb).setOnClickListener{gotoFacebook()}
        findViewById<Button>(R.id.Insta).setOnClickListener{gotoInstagram()}

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

    public fun createSMS() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)

    }

    private fun gotoFacebook() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.setPackage("com.android.facebook")
        if (intent.resolveActivity(this.packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText( applicationContext, "Error, facebook is not installed in this device.", Toast.LENGTH_LONG).show()
        }
    }

    private fun gotoInstagram() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.setPackage("com.android.instagram")
        if (intent.resolveActivity(this.packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText( applicationContext, "Instagram is not installed in this device", Toast.LENGTH_LONG).show()
        }
    }


}