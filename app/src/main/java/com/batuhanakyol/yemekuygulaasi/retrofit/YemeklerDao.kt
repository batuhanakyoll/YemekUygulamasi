package com.batuhanakyol.yemekuygulaasi.retrofit

import com.batuhanakyol.yemekuygulaasi.data.entity.CRUDCevap
import com.batuhanakyol.yemekuygulaasi.data.entity.Sepet_yemeklerCevap
import com.batuhanakyol.yemekuygulaasi.data.entity.YemeklerCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface YemeklerDao {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    @GET("yemekler/tumYemekleriGetir.php")
    fun tumYemekler() :Call<YemeklerCevap>

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    fun sepetEkle( @Field ("yemek_adi") yemek_adi :String ,
                   @Field ("yemek_resim_adi") yemek_resim_adi :String ,
                   @Field ("yemek_fiyat") yemek_fiyat :Int,
                   @Field ("yemek_siparis_adet") yemek_siparis_adet :Int,
                   @Field ("kullanici_adi") kullanici_adi :String ) : Call<CRUDCevap>

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    fun sepettekiYemekleriAlma(@Field("kullanici_adi") kullanici_adi: String) : Call<Sepet_yemeklerCevap>

     @POST("yemekler/sepettenYemekSil.php")
     @FormUrlEncoded
     fun yemekSil( @Field ("sepet_yemek_id") sepet_yemek_id :Int ,
                   @Field ("kullanici_adi") kullanici_adi: String  ) :Call<CRUDCevap>

     @POST(value = "yemekler/tumYemekleriGetir.php")
     @FormUrlEncoded
     fun  ara(@Field("yemek_adi") yemek_adi: String) : Call<YemeklerCevap>
}