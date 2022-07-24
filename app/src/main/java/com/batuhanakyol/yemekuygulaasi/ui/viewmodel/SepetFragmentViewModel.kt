package com.batuhanakyol.yemekuygulaasi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.batuhanakyol.yemekuygulaasi.data.entity.Sepet_yemekler
import com.batuhanakyol.yemekuygulaasi.data.entity.Yemekler
import com.batuhanakyol.yemekuygulaasi.data.repo.YemeklerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SepetFragmentViewModel @Inject constructor(var krepo: YemeklerDaoRepository) : ViewModel() {
    var sepetlistesi = MutableLiveData<List<Sepet_yemekler>>()

    init {
        sepetYemekYukle("Batuhan Akyol")
        sepetlistesi = krepo.sepetyemekleriGetir()
    }

    fun sil(sepet_yemek_id : Int ,kullanici_adi: String){
        krepo.yemekSil(sepet_yemek_id,kullanici_adi)
    }

    fun sepetYemekYukle(kullanici_adi: String){
        krepo.sepetYemekAl(kullanici_adi)
    }



}
