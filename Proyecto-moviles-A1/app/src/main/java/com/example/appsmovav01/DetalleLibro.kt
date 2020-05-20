package com.example.appsmovav01

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_detalle_libro.*
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception

class DetalleLibro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_libro)

        val bundle = intent.extras
        var nombreLibro:String?=null

        if (bundle != null){
            iv_libro_imagen.setImageResource(bundle.getInt("header"))
            tv_nombre_libro.setText(bundle.getString("titulo"))
            tv_libro_desc.setText(bundle.getString("sinopsis"))
            nombreLibro = bundle.getString("titulo")
        }

        btn_guardar.setOnClickListener {
            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference("Libro")

            myRef.setValue(nombreLibro)
            Toast.makeText(this,"Guardado con exito",Toast.LENGTH_SHORT).show()
        }

    }



}
