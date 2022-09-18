package com.ibrahim.week4.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.ibrahim.week4.adapter.PlanetAdapter
import com.ibrahim.week4.databinding.FragmentMenuBinding
import com.ibrahim.week4.model.PlanetListItem
import com.ibrahim.week4.service.PlanetAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuFragment :Fragment() {

    private lateinit var fragmentMenuBinding: FragmentMenuBinding
    lateinit var planetAdapter: PlanetAdapter  //Adapter tanımlama
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        //binding işlemi
        fragmentMenuBinding = FragmentMenuBinding.inflate(inflater, container, false)
        return fragmentMenuBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        fetchPlace()
    }

    private fun initAdapter() {
        //Adapter Tanımlayıp başlatma
        planetAdapter = PlanetAdapter()
        fragmentMenuBinding.menuRecyclerview.adapter = planetAdapter
        //Adapterin Ekrandaki Görünümü
        val layoutManager = GridLayoutManager(requireContext(),2)
        fragmentMenuBinding.menuRecyclerview.layoutManager = layoutManager
    }

    private fun fetchPlace() {
        fragmentMenuBinding.menuRecyclerview.isVisible = false
        fragmentMenuBinding.menuProgress.isVisible = true
        //Servise istek atma
        val request = PlanetAPI().getPlanetService().getPlanet("")
        request.enqueue(object :Callback<List<PlanetListItem>>{
            override fun onResponse(
                call: Call<List<PlanetListItem>>,
                response: Response<List<PlanetListItem>>) {
                planetAdapter.setList(response.body() ?: emptyList())
            //servisten cevap geldiğinde recyclerViewı görünür ProgressBarı görünmez yapma
            fragmentMenuBinding.menuRecyclerview.isVisible = true
            fragmentMenuBinding.menuProgress.isVisible = false
        }

            override fun onFailure(call: Call<List<PlanetListItem>>, t: Throwable) {
                //Servisten cevap gelmediğinde hata mesajı
                Toast.makeText(requireContext(),t.message.toString(), Toast.LENGTH_LONG).show()
                fragmentMenuBinding.menuRecyclerview.isVisible = true
                fragmentMenuBinding.menuProgress.isVisible = false
            }
        })
    }}