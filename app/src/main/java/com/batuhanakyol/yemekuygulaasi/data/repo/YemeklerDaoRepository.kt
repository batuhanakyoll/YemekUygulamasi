package com.batuhanakyol.yemekuygulaasi.data.repo

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import com.batuhanakyol.yemekuygulaasi.R
import com.batuhanakyol.yemekuygulaasi.data.entity.*
import com.batuhanakyol.yemekuygulaasi.retrofit.YemeklerDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YemeklerDaoRepository(var kdao : YemeklerDao) {
    var yemeklerListesi:MutableLiveData<List<Yemekler>>
    var sepetlerListesi:MutableLiveData<List<Sepet_yemekler>>

    init {
        yemeklerListesi = MutableLiveData()
        sepetlerListesi = MutableLiveData()
    }

    fun yemekAra(aramaKelimesi:String){
        kdao.tumYemekler().enqueue(object : Callback<YemeklerCevap>{
            override fun onFailure(call: Call<YemeklerCevap>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<YemeklerCevap>?,response: Response<YemeklerCevap>) {

             val liste = response.body()!!.yemekler
                val sonuc = liste.filter {
                    it.yemek_adi.contains(aramaKelimesi,true)
                }
                yemeklerListesi.value = sonuc
            }
        })
    }
    fun sepetyemekleriGetir() : MutableLiveData<List<Sepet_yemekler>> {

        return sepetlerListesi
    }

    fun sepeteEkle(yemek_adi:String,yemek_resim_adi :String,yemek_fiyat:Int ,yemek_siparis_adet:Int,kullanici_adi: String ){
        kdao.sepetEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {
                    val basari = response.body().success
                    val mesaj = response.body().message
                    Log.e("Sepet", "$basari - $mesaj")
            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {
            }
        })
    }



         fun yemekleriGetir(): MutableLiveData<List<Yemekler>>{

        return yemeklerListesi
    }

    fun tumYemekleriAl(){
        kdao.tumYemekler().enqueue(object:Callback<YemeklerCevap>{
            override fun onResponse( call: Call<YemeklerCevap>?, response: Response<YemeklerCevap>){
                val liste = response.body().yemekler
                yemeklerListesi.value = liste
            }

            override fun onFailure(call: Call<YemeklerCevap>?, t: Throwable?) {

            }
        })
    }
       fun sepetYemekAl(kullanici_adi: String){
            kdao.sepettekiYemekleriAlma(kullanici_adi).enqueue(object :Callback<Sepet_yemeklerCevap>{
                override fun onResponse(call: Call<Sepet_yemeklerCevap>?,response: Response<Sepet_yemeklerCevap>) {
                   val liste = response.body().sepet_yemekler
                    sepetlerListesi.value = liste
                }

                override fun onFailure(call: Call<Sepet_yemeklerCevap>?, t: Throwable?) {
                }
            })
       }

        fun yemekSil(sepet_yemek_id :Int , kullanici_adi: String){
            kdao.yemekSil(sepet_yemek_id,kullanici_adi).enqueue(object : Callback<CRUDCevap>{
                override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {  }

                override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {


                    sepetYemekAl(kullanici_adi)
                }
            })

        }

    fun  detayButtonSepeteTikla( yemek_adi:String, yemek_resim_adi :String, yemek_fiyat:Int , yemek_siparis_adet:Int, kullanici_adi: String ){
        kdao.sepetEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {
                val basari = response.body().success
                val mesaj = response.body().message
                Log.e("Sepet", "$basari - $mesaj")
            }

            override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {
            }
        })

    }



    }

