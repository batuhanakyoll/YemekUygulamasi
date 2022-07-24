package com.batuhanakyol.yemekuygulaasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.batuhanakyol.yemekuygulaasi.R
import com.batuhanakyol.yemekuygulaasi.databinding.FragmentDetayBinding
import com.batuhanakyol.yemekuygulaasi.ui.viewmodel.AnasayfaFragmentViewModel
import com.batuhanakyol.yemekuygulaasi.ui.viewmodel.DetayFragmentViewModel
import com.batuhanakyol.yemekuygulaasi.util.gecisYap
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {

    private lateinit var tasarim : FragmentDetayBinding
    private lateinit var viewModel : DetayFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle? ): View? {
        tasarim = FragmentDetayBinding.inflate(inflater, container, false)


        val bundle: DetayFragmentArgs by navArgs()
        val yemek = bundle.yemekDetay

        val resim_adi = yemek.yemek_resim_adi
        val url = "http://kasimadalan.pe.hu/yemekresimler/"
        val son_resim_adi = "${url}${resim_adi}"
        var yemek_siparis_adet = 0
        var kullanici_adi = "Batuhan Akyol"
        Picasso.get().load(son_resim_adi).into(tasarim.dtResim)
        tasarim.dtYemekAd.text = yemek.yemek_adi
        tasarim.dtFiyat.text = "${yemek.yemek_fiyat}₺"
        tasarim.toolbarDetay.title = yemek.yemek_adi
        tasarim.dtMNus.setOnClickListener {
            if(yemek_siparis_adet <= 1){
                tasarim.dtAdet.text = yemek_siparis_adet.toString()
            }
            else
                yemek_siparis_adet--
            tasarim.dtAdet.text = yemek_siparis_adet.toString()


        }
        tasarim.dtAdd.setOnClickListener {
            yemek_siparis_adet++
            tasarim.dtAdet.text = yemek_siparis_adet.toString()
        }

        tasarim.dtSepet.setOnClickListener {

            var yemek_adi = yemek.yemek_adi
            var yemek_resim_adi = yemek.yemek_resim_adi
            var yemek_fiyat = yemek.yemek_fiyat
             buttonsepeteTikla(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)

        }
        return tasarim.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : DetayFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }


      fun  buttonsepeteTikla( yemek_adi:String, yemek_resim_adi :String, yemek_fiyat:Int , yemek_siparis_adet:Int, kullanici_adi: String ){
          viewModel.detaysepet(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)


        }
}