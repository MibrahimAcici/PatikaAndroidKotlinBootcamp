package com.ibrahim.week4.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ibrahim.week4.databinding.ItemPlanetBinding
import com.ibrahim.week4.fragments.MenuFragmentDirections
import com.ibrahim.week4.model.PlanetListItem

class PlanetAdapter() : RecyclerView.Adapter<PlanetAdapter.PlanetVH>() {

    private var planetList: ArrayList<PlanetListItem> = arrayListOf()

    fun setList(newList: List<PlanetListItem>) {
        this.planetList.clear()
        this.planetList.addAll(newList)
        notifyDataSetChanged()
    }

    inner class PlanetVH(val binding: ItemPlanetBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetVH {
        return PlanetVH(ItemPlanetBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PlanetVH, position: Int) {
        val planet=planetList[position]

        //Glide ile URL'i image'e dönüştürme
        Glide.with(holder.binding.imagePlanet.context)
            .load(planet.imgSrc)
            .into(holder.binding.imagePlanet)

        //RecyclerView'daki item'a tıklandığında PlanetDetailFragment'a geçiş ve argument'ı gönderme
        holder.binding.root.setOnClickListener {
            val action= MenuFragmentDirections.actionMenuFragmentToPlanetDetailFragment(planet)
            Navigation.findNavController(it).navigate(action)
        }

    }
    override fun getItemCount(): Int = planetList.size

}