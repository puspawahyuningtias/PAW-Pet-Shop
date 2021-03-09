package com.puspawahyuningtias.paw

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Produk(
    var name: String = "",
    var harga: String = "",
    var deskripsi: String = "",
    var photo: Int = 0,
    var kategori: String = "",
    var jenis: String = ""
): Parcelable