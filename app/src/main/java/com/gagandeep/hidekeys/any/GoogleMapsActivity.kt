package com.gagandeep.hidekeys.any

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.gagandeep.hidekeys.BuildConfig
import com.gagandeep.hidekeys.R

class GoogleMapsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_maps)

        val apiKey = BuildConfig.MAPS_API_KEY

        findViewById<TextView>(R.id.tvLabel).apply {
            text = apiKey
        }
    }
}

object Keys {
    init {
        System.loadLibrary("keys")
    }
    external fun getApiKey(): String
}