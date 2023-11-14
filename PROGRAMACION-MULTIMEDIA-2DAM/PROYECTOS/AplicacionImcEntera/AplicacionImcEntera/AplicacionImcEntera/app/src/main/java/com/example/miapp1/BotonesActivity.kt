package com.example.miapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class BotonesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.botones)
        val btnSaludar=findViewById<Button>(R.id.btnSaludApp)
        btnSaludar.setOnClickListener{navigateToSaludar()}
        btnSaludar.setOnClickListener{Toast.makeText(this,"HolaUsuariooooooooooooooooooooooooo",Toast.LENGTH_SHORT).show()}
        val btnimc=findViewById<Button>(R.id.btnIMCApp)
        btnimc.setOnClickListener{navigateToImcApp()}
        val btmTodoApp=findViewById<Button>(R.id.btnTodoApp)
        btmTodoApp.setOnClickListener{(navigateToTodoApp())}
    }

    fun navigateToSaludar(){
        val intent= Intent(this,MainActivity::class.java)
        startActivity(intent)

    }

    fun navigateToImcApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    fun navigateToTodoApp() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }
}