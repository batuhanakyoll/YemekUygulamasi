package com.batuhanakyol.yemekuygulaasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.batuhanakyol.yemekuygulaasi.R
import com.batuhanakyol.yemekuygulaasi.databinding.FragmentGirisBinding
import com.google.android.material.snackbar.Snackbar


class GirisFragment : Fragment() {
    private lateinit var tasarim : FragmentGirisBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle? ): View? {

        tasarim = FragmentGirisBinding.inflate(inflater, container, false)


        tasarim.button2.setOnClickListener {

            Snackbar.make(it,"Acıktıysanız en doğru yerdesiniz.",Snackbar.LENGTH_SHORT).show()

        }




        return tasarim.root
    }
}
