package com.example.appsmovav01.ui.profile

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appsmovav01.AdaptadorNotas
import com.example.appsmovav01.Nota
import com.example.appsmovav01.R
import com.example.appsmovav01.ui.gallery.GalleryViewModel
import kotlinx.android.synthetic.main.fragment_profile.*
import java.io.*


class Profile : Fragment() {


    private lateinit var ProfileViewModel: ProfileViewModel

    var notas = ArrayList<Nota>()
    lateinit var adaptador: AdaptadorNotas


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ProfileViewModel =
            ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_profile, container, false)

        return root

        notasDePrueba()

        leerNotas()

        adaptador = AdaptadorNotas(root.context,notas)
        listview.adapter=adaptador
    }


    fun leerNotas() {
        notas.clear()
        var carpeta = File(ubicacion().absolutePath)

        if (carpeta.exists()) {
            var archivos = carpeta.listFiles()
            if (archivos != null) {
                for (archivo in archivos) {
                    leerArchivo(archivo)
                }
            }
        }
    }

    fun leerArchivo(archivo: File){
        val fis = FileInputStream(archivo)
        val di = DataInputStream(fis)
        val br = BufferedReader(InputStreamReader(di))
        var strLine: String? = br.readLine()
        var myData = ""

        while (strLine != null){
            myData = myData + strLine
            strLine = br.readLine()
        }
        br.close()
        di.close()
        fis.close()

        var nombre = archivo.name.substring(0, archivo.name.length-4)
        var nota = Nota(nombre,myData)
        notas.add(nota)

    }

    private fun ubicacion(): File {
        val folder = File(Environment.getExternalStorageDirectory(), "notas")
        if (!folder.exists()){
            folder.mkdir()
        }
        return folder
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //Se activa cuando regresa al agregarNotaActivity

        if (requestCode==123){
            leerNotas()
            adaptador.notifyDataSetChanged()
        }

    }

    fun notasDePrueba(){
        notas.add(Nota("prueba 1","Libro1"))
        notas.add(Nota("prueba 2","Libro2"))


    }


}
