package com.ibrahim.week4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.ibrahim.week4.databinding.FragmentPlanetDetailBinding

class PlanetDetailFragment :Fragment() {
    private lateinit var fragmentPlanetDetailbinding: FragmentPlanetDetailBinding
    private val args: PlanetDetailFragmentArgs by navArgs() //adapter ile gelen argumentı tanımlama

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        //binding işlemi
        fragmentPlanetDetailbinding = FragmentPlanetDetailBinding.inflate(inflater, container, false)
        return fragmentPlanetDetailbinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initPlanetDetailClickListeners()

    }

    private fun initPlanetDetailClickListeners() {
        //Glide ile URL'i image'e dönüştürme
        Glide.with(requireContext())
            .load(args.planet.imgSrc)
            .into(fragmentPlanetDetailbinding.planetDetailImageview)

        //argument kullanımı
        fragmentPlanetDetailbinding.planetDetailButtonId.text = "ID : " + args.planet.id.toString()
        fragmentPlanetDetailbinding.planetDetailButtonType.text = "Type : " + args.planet.type.toString()
        fragmentPlanetDetailbinding.planetDetailButtonPrice.text = args.planet.price.toString() + " USD"

        //back butonuna basıldığında MenuFragment'a geçiş
        fragmentPlanetDetailbinding.planetDetailToolbarBackButton.setOnClickListener {
            val action= PlanetDetailFragmentDirections.actionPlanetDetailFragmentToMenuFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}