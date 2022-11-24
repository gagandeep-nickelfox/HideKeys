package com.gagandeep.hidekeys

import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.gagandeep.hidekeys.databinding.ActivityMainBinding
import com.google.firebase.crashlytics.internal.common.CommonUtils


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )

        setContentView(binding.root)

//        saveUsingSharedPrefs()

        saveUsingEncryptedSharedPrefs()

        val isRooted = CommonUtils.isRooted(this)
    }

    private fun saveUsingEncryptedSharedPrefs() {
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

        val sharedPrefsFile = "my_prefs"
        val sharedPreferences: SharedPreferences = EncryptedSharedPreferences.create(
            sharedPrefsFile,
            masterKeyAlias,
            applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        with(sharedPreferences.edit()) {
            // Edit the user's shared preferences...
            putString("username", "gagandeep-nickelfox")
            apply()
        }

        BuildConfig.MAPS_API_KEY

//        findViewById<TextView>(R.id.tvLabel).apply {
//            text = sharedPreferences.getString("username", "default_value")
//        }
    }

    private fun saveUsingSharedPrefs() {

        val sharedPrefsFile = "my_prefs"
        val sharedPreferences: SharedPreferences =
            getSharedPreferences(sharedPrefsFile, MODE_PRIVATE)

        with(sharedPreferences.edit()) {
            // Edit the user's shared preferences...
            putString("username", "gagandeep-nickelfox")
            apply()
        }
//
//        findViewById<TextView>(R.id.tvLabel).apply {
//            text = sharedPreferences.getString("username", "default_value")
//        }
    }

/*    override fun onPause() {
        super.onPause()
        binding.apply {
//            root.foreground = ColorDrawable(Color.BLACK)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.apply {
//            root.foreground = null
        }
    }*/
}



