package com.example.applicationactivities88

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.Intent.ACTION_CALL
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat


val REQUEST_PHONE_CALL = 1

class SecondActivity: AppCompatActivity(R.layout.activity_second){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val number: TextView = findViewById<TextView>(R.id.tvNumberCall)


        val phoneNumber = "123456"

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CALL_PHONE),
                REQUEST_PHONE_CALL
            )
        } else {


            var numberFromFirstActivity :String = intent.getStringExtra("number").toString()
            number.setText("Dialing number \n $numberFromFirstActivity")
            val phoneNumber ="+7"+numberFromFirstActivity
            val intentNumber = Intent (ACTION_CALL)
            intentNumber.data = Uri.parse ("tel:" + phoneNumber)
            startActivity (intentNumber)


            }
        }
    }



