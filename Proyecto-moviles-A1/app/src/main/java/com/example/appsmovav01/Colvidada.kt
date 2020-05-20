package com.example.appsmovav01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_colvidada.*

class Colvidada : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colvidada)

        mAuth = FirebaseAuth.getInstance()

        btn_enviar_correo.setOnClickListener{
            var correo = txt_Colvidada.text.toString()

            if (!correo.isNullOrEmpty()){

                mAuth?.sendPasswordResetEmail(correo)
                    ?.addOnCompleteListener{ task ->
                        if(task.isSuccessful){
                            Toast.makeText(this, "Se envió un correo a $correo",
                                Toast.LENGTH_LONG).show()

                            finish()
                        }else{
                            Toast.makeText(this, "Error al enviar correo",
                                Toast.LENGTH_SHORT).show()
                        }

                    }


            }else{
                Toast.makeText(this, "Ingresar correo",
                    Toast.LENGTH_SHORT).show()
            }


        }

    }
}
