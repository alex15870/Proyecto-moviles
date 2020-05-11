package com.example.appsmovav01.ui.profile2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.appsmovav01.R
import com.example.appsmovav01.ui.home.HomeViewModel

class Profile2 : Fragment() {


    private lateinit var profile2ViewModel: Profile2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profile2ViewModel =
            ViewModelProviders.of(this).get(Profile2ViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        //val textView: TextView = root.findViewById(R.id.tv_hola)
        //homeViewModel.text.observe(viewLifecycleOwner, Observer {
        //textView.text = it
        //})
        return root
    }
}