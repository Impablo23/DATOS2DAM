package com.example.cinepabloricomachio

import android.app.Activity
import android.content.Intent
import android.content.Intent.ACTION_SENDTO
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.Toast


class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_activity)
        val btnSitioWeb=findViewById<Button>(R.id.btnWeb)
        btnSitioWeb.setOnClickListener{abrirSitioWeb()}
        val btnSitioSoporte=findViewById<Button>(R.id.btnSupport)
        btnSitioSoporte.setOnClickListener{abrirEmail()}
        val btnSitioVolver=findViewById<Button>(R.id.btnReturn)
        btnSitioVolver.setOnClickListener{finish()}
        


    }




    private fun abrirSitioWeb() {
        val intent = Intent(ACTION_VIEW, Uri.parse("http://www.midominio.com"))
        startActivity(intent)
    }

    private fun abrirEmail() {
        val intent = Intent(ACTION_SENDTO)
        intent.data = Uri.parse("mailto:midireccion@dominio.com.")
        startActivity(intent)
    }



}