package com.example.appsmovav01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_principal.*

class Pprincipal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        btn_tengo_cuenta.setOnClickListener(View.OnClickListener {
            var intent = Intent(this, ISesion::class.java)
            startActivity(intent)
        })

        txt_Rcontrasena.setOnClickListener(View.OnClickListener {
            var intent = Intent(this, Colvidada::class.java)
            startActivity(intent)
        })



        txt_registro.setOnClickListener(View.OnClickListener {
            var intent = Intent(this, Registro::class.java)
            startActivity(intent)
        })



    }
}
