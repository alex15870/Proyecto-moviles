package com.example.appsmovav01.ui.Favoritos

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appsmovav01.R


class Favoritos : Fragment() {



    companion object {
        fun newInstance() = Favoritos()
    }

    private lateinit var viewModel: FavoritosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_favorites, container, false)



    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FavoritosViewModel::class.java)
        // TODO: Use the ViewModel



    }



}

