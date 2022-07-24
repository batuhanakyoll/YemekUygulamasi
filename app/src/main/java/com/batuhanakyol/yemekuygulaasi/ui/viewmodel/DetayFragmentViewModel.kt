package com.batuhanakyol.yemekuygulaasi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.batuhanakyol.yemekuygulaasi.data.entity.Yemekler
import com.batuhanakyol.yemekuygulaasi.data.repo.YemeklerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetayFragmentViewModel @Inject constructor(var krepo: YemeklerDaoRepository) : ViewModel() {

    fun detaysepet(yemek_adi: String,yemek_resim_adi: String,yemek_fiyat: Int,yemek_siparis_adet: Int,kullanici_adi: String) {
        krepo.detayButtonSepeteTikla(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, kullanici_adi)
    }
}



