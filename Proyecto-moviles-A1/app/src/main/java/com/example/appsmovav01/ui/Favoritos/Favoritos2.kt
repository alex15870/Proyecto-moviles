package com.example.appsmovav01.ui.Trending

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.appsmovav01.DetalleLibro
import com.example.appsmovav01.R
import com.example.appsmovav01.ui.Favoritos.Favorito
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.core.Tag
import kotlinx.android.synthetic.main.favoritos.view.*
import kotlinx.android.synthetic.main.fragment_favorites.*
import kotlinx.android.synthetic.main.fragment_favorites.view.*
import kotlinx.android.synthetic.main.fragment_trending.view.*
import kotlinx.android.synthetic.main.populares.view.*
import kotlinx.android.synthetic.main.populares.view.tv_titulo

class Favoritos2 : Fragment() {

    private lateinit var favoritos2ViewModel: Favoritos2ViewModel

    var adapter: LibrosAdapter? = null
    var favoritos = ArrayList<Favorito>()
    var datos = ArrayList<String>()
    var prueba: String? = null

    companion object {
        private const val TAG = "KotlinActivity"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        favoritos2ViewModel = ViewModelProviders.of(this).get(Favoritos2ViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_favorites, container, false)

        cargaDatos()

        adapter = LibrosAdapter(root.context, favoritos)
        root.gridviewFavs.adapter = adapter

        return root
    }

    fun cargaDatos(){
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Favoritos")

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for (postSnapshot in dataSnapshot.children) {
                    // TODO: handle the post
                    Log.d(TAG,"libro: "+postSnapshot.getValue().toString())
                    favoritos.add(Favorito("${postSnapshot.getValue()}","prueba"))
                    prueba=postSnapshot.getValue().toString()
                    adapter?.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
    }


    class LibrosAdapter: BaseAdapter {
        var favoritos= ArrayList<Favorito>()
        var context: Context? = null

        constructor(context: Context, favoritos: ArrayList<Favorito>){
            this.context = context
            this.favoritos = favoritos
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var libro = favoritos[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as  LayoutInflater
            var vista = inflator.inflate(R.layout.favoritos, null)
            vista.tv_titulo.text = libro.titulo.toString()


            return vista
        }

        override fun getItem(p0: Int): Any {
            return favoritos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return favoritos.size
        }
    }
}

