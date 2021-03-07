package com.puspawahyuningtias.paw

object KategoriData {
    private val namaKategori = arrayOf(
        "Makanan",
        "Apotek",
        "Grooming",
        "aksesoris"
    )
    private val iconKategory = intArrayOf(
        R.drawable.icon1,
        R.drawable.icon2,
        R.drawable.icon3,
        R.drawable.icon4
    )

    val listData: ArrayList<kategori>get(){
        val list = arrayListOf<kategori>()
        for (position in namaKategori.indices){
            val kategori = kategori()
            kategori.name = namaKategori[position]
            kategori.icon = iconKategory[position]
            list.add(kategori)
        }
        return list
    }
}