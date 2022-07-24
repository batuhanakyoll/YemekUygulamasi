package com.batuhanakyol.yemekuygulaasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.lottie.LottieDrawable
import com.batuhanakyol.yemekuygulaasi.R
import com.batuhanakyol.yemekuygulaasi.databinding.FragmentSonucBinding

class SonucFragment : Fragment() {

    private lateinit var tasarim : FragmentSonucBinding
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

    tasarim = FragmentSonucBinding.inflate(inflater, container, false)

        tasarim.toolbar2.title = "Satın Alma İşlemi Gerçekleşti"

        return tasarim.root
    }


}