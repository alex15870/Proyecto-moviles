package com.example.appsmovav01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_face_login.*
import kotlinx.android.synthetic.main.activity_pruebas.*

class FaceLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_face_login)

        btn_continuar.setOnClickListener(View.OnClickListener {
            var intent = Intent(this, ISesion::class.java)
            startActivity(intent)
        })

    }


}
