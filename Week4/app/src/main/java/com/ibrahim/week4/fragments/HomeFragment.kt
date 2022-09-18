package com.ibrahim.week4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ibrahim.week4.databinding.FragmentHomeBinding

class HomeFragment :Fragment() {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        //binding işlemi
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initHomeClickListeners()
    }

    private fun initHomeClickListeners() {
        //LetsGo butonuna basıldığında MenuFragment'a geçiş
        fragmentHomeBinding.homeRelativeButtonLetsgo.setOnClickListener {
            val action= HomeFragmentDirections.actionHomeFragmentToMenuFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}