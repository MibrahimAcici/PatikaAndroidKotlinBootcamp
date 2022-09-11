package com.ibrahim.fragmentlifecycle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ibrahim.fragmentlifecycle.databinding.FragmentHomeBinding

class HomeFragment :Fragment() {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View { //binding ile layout eşleştirme
        //binding ile layout eşleştirme
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClickListeners()

    }

    private fun initClickListeners() {
        //homesavebuttona tıklandığında buttonClick fonksiyonunu çalıştır
        fragmentHomeBinding.homeSaveButton.setOnClickListener {
            buttonClick() }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        //savedInstance boş değilse
        savedInstanceState?.let {

            //Bundle'ı alıp content değerine atadık
            val content = it.getString(ConstantValue.NAME, "patika")

            //Content değerini ekrandaki homeNameTextview'a atadık
            fragmentHomeBinding.homeNameTextview.text = content
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        //homeNameTextview'ı alıp textViewMessage değerine atadık
        val textViewMessage = fragmentHomeBinding.homeNameTextview.text.toString()

        //textViewMessage'daki texti bundle'a gönderdik
        outState.putString(ConstantValue.NAME, textViewMessage)

    }

    private fun buttonClick() {
        //Textinput'a girilen değeri alıp editTextContent değerine atadık
        val editTextContent = fragmentHomeBinding.homeNameTextinput.text.toString()

        //homeNameTextinput'a girilen değeri homeNameTextview'da gösterdik
        fragmentHomeBinding.homeNameTextview.text = "Girilen İsim: $editTextContent"
    }

}
