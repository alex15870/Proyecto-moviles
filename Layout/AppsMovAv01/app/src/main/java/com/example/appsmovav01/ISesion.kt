package com.example.appsmovav01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_i_sesion.*
import kotlinx.android.synthetic.main.activity_pruebas.*

class ISesion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_i_sesion)

        btn_iniciar.setOnClickListener(View.OnClickListener {
            var intent = Intent(this, MenuPrincipal::class.java)
            startActivity(intent)
        })



    }
}
