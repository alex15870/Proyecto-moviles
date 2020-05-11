package com.example.appsmovav01

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_detalle_libro.*
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception

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

        btn_guardar.setOnClickListener { guardar_nota() }

    }



    fun guardar_nota(){
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED
        ) {
            //si no los tiene pregunta
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                235
            )
            //Si tiene permiso procede a guardar
        }else{
            //sino los guarda
            guardar()
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray){
        when(requestCode){
            235 -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)){

                }else{
                    Toast.makeText(this, "Error: permisos denegados", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }



    public fun guardar(){
        var titulo = tv_nombre_libro.toString()
        var cuerpo = tv_libro_desc.toString()

        if (titulo == "" || cuerpo == ""){
            Toast.makeText(this, "Error: campos vacios", Toast.LENGTH_SHORT).show()
        }else{
            try {
                val archivo = File(ubicacion(), titulo + ".txt")
                val fos = FileOutputStream(archivo)
                fos.write(cuerpo.toByteArray())
                Toast.makeText(
                    this,
                    "se guardo el archivo en la carpeta publica",
                    Toast.LENGTH_SHORT).show()
            }catch (e: Exception){
                Toast.makeText(this, "Error: no se guardo el archivo", Toast.LENGTH_SHORT).show()
            }
        }
        finish()
    }

    private fun ubicacion():String{
        val carpeta = File(Environment.getExternalStorageDirectory(), "notas")
        if (!carpeta.exists()){
            carpeta.mkdir()
        }

        return carpeta.absolutePath
    }
}
