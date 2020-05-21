package com.example.appsmovav01.ui.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.appsmovav01.AdaptadorNotas
import com.example.appsmovav01.R
import com.example.appsmovav01.ui.Favoritos.Favorito
import com.example.appsmovav01.ui.Trending.Favoritos2
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*


class Profile : Fragment() {


    private lateinit var profileViewModel: ProfileViewModel

    var notas = ArrayList<Nota>()
    lateinit var adaptador: AdaptadorNotas
    var adapter: Favoritos2.LibrosAdapter? = null
    var favoritos = ArrayList<Favorito>()
    var datos = ArrayList<String>()
    var prueba: String? = null

    val TAG = "Profile.kt Debug"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        profileViewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_profile, container, false)

        cargaDatos()
        adapter = Favoritos2.LibrosAdapter(root.context, favoritos)
        root.gridviewProfile.adapter=adapter

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentUser = FirebaseAuth.getInstance().currentUser!!.email

        Log.d(TAG, "CURRENT USER: " + currentUser)
        txt_perfil.text = currentUser
    }


    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("Favoritos")

    fun cargaDatos(){
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


}
