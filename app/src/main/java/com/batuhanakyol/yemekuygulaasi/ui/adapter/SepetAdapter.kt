package com.batuhanakyol.yemekuygulaasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.batuhanakyol.yemekuygulaasi.data.entity.Sepet_yemekler
import com.batuhanakyol.yemekuygulaasi.databinding.CardSepetTasarimBinding
import com.batuhanakyol.yemekuygulaasi.databinding.CardTasarimBinding
import com.batuhanakyol.yemekuygulaasi.ui.viewmodel.SepetFragmentViewModel
import com.squareup.picasso.Picasso

class SepetAdapter(var mContext: Context ,
                   var sepetYemeklerListesi : List<Sepet_yemekler>,
                   var viewModel : SepetFragmentViewModel) : RecyclerView.Adapter<SepetAdapter.SepetCardTasarimTutucu>() {

    inner class SepetCardTasarimTutucu(binding:CardSepetTasarimBinding) : RecyclerView.ViewHolder(binding.root)  {

        var binding: CardSepetTasarimBinding

        init {
            this.binding = binding

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SepetCardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding  = CardSepetTasarimBinding.inflate(layoutInflater,parent,false)
        return SepetCardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: SepetCardTasarimTutucu, position: Int) {
            val  sepetYemek = sepetYemeklerListesi.get(position)
            val t  =  holder.binding

            sepetYemek.kullanici_adi = "Batuhan Akyol"
            t.textViewSepetYemek.text = sepetYemek.yemek_adi
            t.textViewFiyat.text = sepetYemek.yemek_fiyat.toString()
            t.textViewSepetAdetSayisi.text = sepetYemek.yemek_siparis_adet.toString()
             val url = "http://kasimadalan.pe.hu/yemekresimler/"
             val resim_adi = sepetYemek.yemek_resim_adi
             val son_resim_adi = "${url}${resim_adi}"
             Picasso.get().load(son_resim_adi).into(t.sepetImageView)


            t.imageViewDelete.setOnClickListener {
                viewModel.sil(sepetYemek.sepet_yemek_id,"Batuhan Akyol")
            }

    }

    override fun getItemCount(): Int {
      return sepetYemeklerListesi.size
    }
}