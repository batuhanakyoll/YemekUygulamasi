package com.batuhanakyol.yemekuygulaasi.data.entity

import com.google.gson.annotations.SerializedName

data class Sepet_yemeklerCevap(@SerializedName("sepet_yemekler")var sepet_yemekler: List<Sepet_yemekler>,
                               @SerializedName("success")var success: Int) {
}