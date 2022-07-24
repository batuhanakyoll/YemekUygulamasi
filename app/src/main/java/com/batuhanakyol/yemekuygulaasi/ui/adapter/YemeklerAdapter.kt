package com.batuhanakyol.yemekuygulaasi.ui.adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.batuhanakyol.yemekuygulaasi.databinding.CardTasarimBinding
import com.batuhanakyol.yemekuygulaasi.data.entity.Yemekler
import com.batuhanakyol.yemekuygulaasi.ui.fragment.AnasayfaFragment
import com.batuhanakyol.yemekuygulaasi.ui.fragment.AnasayfaFragmentDirections
import com.batuhanakyol.yemekuygulaasi.ui.viewmodel.AnasayfaFragmentViewModel
import com.batuhanakyol.yemekuygulaasi.util.gecisYap
import com.squareup.picasso.Picasso

class YemeklerAdapter(var mContext: Context ,
                      var yemeklerListesi: List<Yemekler>,
                      var viewModel:AnasayfaFragmentViewModel) : RecyclerView.Adapter<YemeklerAdapter.CardTasarimTututcu>() {

    inner class CardTasarimTututcu(tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim : CardTasarimBinding


        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTututcu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim  = CardTasarimBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTututcu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTututcu, position: Int) {
        val yemek = yemeklerListesi.get(position)
        val t = holder.tasarim

        var yemek_siparis_adet = 0
        val url = "http://kasimadalan.pe.hu/yemekresimler/"
        val resim_adi = yemek.yemek_resim_adi
        val son_resim_adi = "${url}${resim_adi}"
        val kullanici_adi= "Batuhan Akyol"
        Picasso.get().load(son_resim_adi).into(t.imageViewYemekResmi)
        t.textViewYemekAdi.text = yemek.yemek_adi
        t.textViewFiyat.text = yemek.yemek_fiyat.toString()

        t.imageViewMinus.setOnClickListener {
            if(yemek_siparis_adet <= 1){
                t.textViewAdet.text = yemek_siparis_adet.toString()
            }
            else
                yemek_siparis_adet--
            t.textViewAdet.text = yemek_siparis_adet.toString()


        }
        t.imageViewAdd.setOnClickListener {
            yemek_siparis_adet++
            t.textViewAdet.text = yemek_siparis_adet.toString()
        }


        t.buttonSepeteEkle.setOnClickListener {

            var yemek_adi = yemek.yemek_adi
            var yemek_resim_adi = yemek.yemek_resim_adi
            var yemek_fiyat = yemek.yemek_fiyat
            viewModel.sepet(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi)
        }
        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(yemekDetay = yemek)
            Navigation.gecisYap(it,gecis)
        }

    }


    override fun getItemCount(): Int {
        return  yemeklerListesi.size
    }


}