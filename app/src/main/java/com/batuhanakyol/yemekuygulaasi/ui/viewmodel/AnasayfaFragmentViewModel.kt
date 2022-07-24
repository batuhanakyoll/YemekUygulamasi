package com.batuhanakyol.yemekuygulaasi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.batuhanakyol.yemekuygulaasi.data.entity.Yemekler
import com.batuhanakyol.yemekuygulaasi.data.repo.YemeklerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnasayfaFragmentViewModel @Inject constructor(var krepo: YemeklerDaoRepository) : ViewModel() {

    var yemeklerListesi = MutableLiveData<List<Yemekler>>()

    init {
        yemekleriYukle()
        yemeklerListesi = krepo.yemekleriGetir()
    }

    fun ara(aramaKelimesi:String){
        krepo.yemekAra(aramaKelimesi)
    }
    fun sepet(yemek_adi:String,yemek_resim_adi :String,yemek_fiyat:Int ,yemek_siparis_adet:Int,kullanici_adi: String ){
       krepo.sepeteEkle(yemek_adi,yemek_resim_adi ,yemek_fiyat ,yemek_siparis_adet,kullanici_adi )
    }
    fun yemekleriYukle (){
        krepo.tumYemekleriAl()
    }

}