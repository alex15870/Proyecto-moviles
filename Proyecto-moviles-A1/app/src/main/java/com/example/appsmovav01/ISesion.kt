package com.example.appsmovav01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_face_login.*
import kotlinx.android.synthetic.main.activity_i_sesion.*
import kotlinx.android.synthetic.main.activity_principal.*
import android.widget.Toast
import com.example.appsmovav01.ui.profile.Profile
import com.google.firebase.auth.FirebaseAuth

class ISesion : AppCompatActivity() {

    var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_i_sesion)

        /*btn_iniciar.setOnClickListener(View.OnClickListener {
            var intent = Intent(this, MenuPrincipal::class.java)
            startActivity(intent)
        })*/

        mAuth = FirebaseAuth.getInstance()

        btn_iniciar.setOnClickListener{
            ingresar()
        }

    }

    private fun ingresar(){
        var correo = Email.text.toString()
        var contra = contrasena.text.toString()

        if(!correo.isNullOrEmpty() && !contra.isNullOrEmpty()){

            mAuth?.signInWithEmailAndPassword(correo, contra)
                ?.addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        var intent = Intent(this, MenuPrincipal::class.java)
                        intent.putExtra("usuario", correo)
                        startActivity(intent)

                    }else{
                        Toast.makeText(this,"Error al iniciar sesión",
                            Toast.LENGTH_SHORT).show()
                    }

                }


        }else{
            Toast.makeText(this,"Ingresar datos",
                Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()

        var usuario = mAuth?.currentUser

        if(usuario != null){
            var intent = Intent(this, MenuPrincipal::class.java)
            //var intent2 = Intent(this, Profile::class.java)
            var correo = usuario.email
            intent.putExtra("usuario",correo)
            //intent2.putExtra("usuario",correo)
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()

        mAuth?.signOut()
    }


}
