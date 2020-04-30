package com.example.appsmovav01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_pruebas.*

class pruebas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pruebas)

        btn_tengo_cuenta.setOnClickListener(View.OnClickListener {
            var intent = Intent(this, ISesion::class.java)
            startActivity(intent)
        })

        txt_Rcontrasena.setOnClickListener(View.OnClickListener {
            var intent = Intent(this, Colvidada::class.java)
            startActivity(intent)
        })

        btn_getstarted.setOnClickListener(View.OnClickListener {
            var intent = Intent(this, FaceLogin::class.java)
            startActivity(intent)
        })

        txt_registro.setOnClickListener(View.OnClickListener {
            var intent = Intent(this, Registro::class.java)
            startActivity(intent)
        })



    }
}
