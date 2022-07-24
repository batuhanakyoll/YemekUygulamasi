package com.batuhanakyol.yemekuygulaasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.batuhanakyol.yemekuygulaasi.R
import com.batuhanakyol.yemekuygulaasi.data.entity.Sepet_yemekler
import com.batuhanakyol.yemekuygulaasi.databinding.FragmentSepetBinding
import com.batuhanakyol.yemekuygulaasi.ui.adapter.SepetAdapter
import com.batuhanakyol.yemekuygulaasi.ui.viewmodel.SepetFragmentViewModel
import com.batuhanakyol.yemekuygulaasi.util.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SepetFragment : Fragment() {

    private lateinit var tasarim : FragmentSepetBinding
    private lateinit var viewModel : SepetFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_sepet,container,false)
        tasarim.sepetFragment = this
        tasarim.sepetToolbarBaslik = "Batuhan Akyol"

    viewModel.sepetlistesi.observe(viewLifecycleOwner){
        val adapter = SepetAdapter(requireContext(),it,viewModel)
        tasarim.sepetAdapter = adapter
        tasarim.rvSepet.isInvisible = false

    }


        return tasarim.root
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:SepetFragmentViewModel by viewModels()
        viewModel = tempViewModel
    }

        fun butonTikla(v:View ){
            Navigation.gecisYap(v,R.id.sonucGecis)
            for (i in viewModel.sepetlistesi.value!!){
                tasarim.rvSepet.isInvisible = true
                viewModel.sil(i.sepet_yemek_id , "Batuhan Akyol")
            }
        }

    override fun onResume() {
        super.onResume()
        viewModel.sepetYemekYukle("Batuhan Akyol")
    }

    }
