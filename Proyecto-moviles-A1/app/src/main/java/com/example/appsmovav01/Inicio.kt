package com.example.appsmovav01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main1.*

class Inicio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        logo_helu.setOnClickListener(View.OnClickListener {
            var intent = Intent(this, Pprincipal::class.java)
            startActivity(intent)
        })

    }
}
