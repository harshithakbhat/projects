package com.harshi.food2go

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
var titleName:String?="Food2Go"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        setContentView(R.layout.scrollview_example)
        titleName=sharedPreferences.getString("Title","Food2Go")

        title=titleName




    }




    }
