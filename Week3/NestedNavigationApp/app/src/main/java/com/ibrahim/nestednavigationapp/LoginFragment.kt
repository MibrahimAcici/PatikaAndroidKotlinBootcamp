package com.ibrahim.nestednavigationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ibrahim.nestednavigationapp.databinding.FragmentLoginBinding

class LoginFragment :Fragment() {

    private lateinit var fragmentLoginBinding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        //binding ile layout eşleştirme
        fragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false)
        return fragmentLoginBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentLoginBinding.apply {
            //login butonuna basıldığında main fragment'a git
            loginLoginButton.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
            }
        }
    }
}
