package com.example.myapplicationprueba2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    var TAG= ":::TAG"
    override fun onCreate(savedInstanceState: Bundle?) {
        variablesYConstantes()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun variablesYConstantes(){
        var primeraVariable= "Hello World"
        Log.d(TAG,primeraVariable)
    }
}