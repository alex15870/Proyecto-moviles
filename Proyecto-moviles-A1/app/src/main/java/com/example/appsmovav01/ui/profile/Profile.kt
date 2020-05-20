package com.example.appsmovav01.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.appsmovav01.AdaptadorNotas
import com.example.appsmovav01.R


class Profile : Fragment() {


    private lateinit var profileViewModel: ProfileViewModel

    var notas = ArrayList<Nota>()
    lateinit var adaptador: AdaptadorNotas


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel =
            ViewModelProviders.of(this).get(ProfileViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_profile, container, false)



        return root


    }


}
