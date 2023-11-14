package com.example.cinepabloricomachio

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NameActivity : AppCompatActivity() {
    //companion object es un singleton asociado a la calse, y podremos acceder a sus miembros directamente a partir
    //del nombre de la clase, por ejemplo NameActivity.EXTRA_NAME.
    companion object{
        val EXTRA_NAME = "EXTRA_NAME"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        val buttonSend = findViewById<Button>(R.id.buttonSend)

        buttonSend.setOnClickListener{returnName()}
    }

    private fun returnName() {
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val name = editTextName.text.toString()
        if (name.isEmpty()){
            setResult(Activity.RESULT_CANCELED)
        }else{
            val result = Intent()
            result.putExtra(EXTRA_NAME,name)
            setResult(Activity.RESULT_OK, result)
        }
        finish()
    }
}