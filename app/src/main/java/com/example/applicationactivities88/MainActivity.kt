package com.example.applicationactivities88

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val action_call_button: Button = findViewById(R.id.action_call_button)

        val InfoToUser: TextView = findViewById (R.id.tvInfoToUser)

        val editNumber: EditText = findViewById(R.id.editNumber)

        InfoToUser.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        action_call_button.setOnClickListener {

            val number = editNumber.getText().toString()
            if (number.length == 10) {
                val intent = Intent(this, SecondActivity::class.java)
                Intent(intent)
                intent.putExtra("number", number)
                startActivity(intent);
            } else InfoToUser.text = "Enter phone number"

        }

    }
}

