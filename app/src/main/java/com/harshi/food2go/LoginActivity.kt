package com.harshi.food2go

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {


    lateinit var etmnum: EditText
    lateinit var etPassword: EditText
    lateinit var btnlogin: Button
    lateinit var txtForgotpassword: TextView
    lateinit var txtRegister: TextView
    val validmobilenumber = "0123456789"
    val validpassword = "abcdefg"
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("is logged in", false)
        setContentView(R.layout.activity_login)
        if (isLoggedIn) {
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }




        title = "FOOD2GO"

        etmnum = findViewById(R.id.etmnum)
        etPassword = findViewById(R.id.etPassword)
        btnlogin = findViewById(R.id.btnlogin)
        txtForgotpassword = findViewById(R.id.txtForgotpassword)
        txtRegister = findViewById(R.id.txtRegister)


        btnlogin.setOnClickListener {

            val mobilenumber = etmnum.text.toString()
            val password = etPassword.text.toString()


            if (mobilenumber == validmobilenumber && password == validpassword) {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
                savePreferences(mobilenumber)
            } else {

                Toast.makeText(
                    this@LoginActivity,
                    "Incorrect Cerdentials..!!!",
                    Toast.LENGTH_LONG
                ).show()
                savePreferences(mobilenumber)
            }

        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(title: String) {
        sharedPreferences.edit().putBoolean("is logged in", true).apply()
        sharedPreferences.edit().putString("Title", title).apply()
    }

}