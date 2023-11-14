package com.example.miapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MIAPP1funcionalidad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.miapp1funcionalidad)
        var tvResult=findViewById<TextView>(R.id.tvResult)
        val name: String =intent.extras?.getString("EXTRA_NAME").orEmpty()
        tvResult.text="Hello $name"
    }
}