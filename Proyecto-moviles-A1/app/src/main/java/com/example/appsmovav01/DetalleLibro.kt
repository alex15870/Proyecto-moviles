package com.example.appsmovav01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle_libro.*

class DetalleLibro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_libro)

        val bundle = intent.extras

        if (bundle != null){
            iv_libro_imagen.setImageResource(bundle.getInt("header"))
            tv_nombre_libro.setText(bundle.getString("titulo"))
            tv_libro_desc.setText(bundle.getString("sinopsis"))
        }

    }
}
