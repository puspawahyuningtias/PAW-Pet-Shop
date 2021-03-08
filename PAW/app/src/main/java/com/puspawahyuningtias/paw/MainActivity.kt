package com.puspawahyuningtias.paw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvKategori: RecyclerView
    private lateinit var rvProduk: RecyclerView
    private var list: ArrayList<kategori> = arrayListOf()
    private var listProduk: ArrayList<Produk> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvKategori = findViewById(R.id.rv_kategori)
        rvKategori.setHasFixedSize(true)
        rvProduk = findViewById(R.id.rv_produk)
        rvProduk.setHasFixedSize(true)

        list.addAll(KategoriData.listData)
        showRecyclerList()
        listProduk.addAll(ProdukData.listData)
        showRecyclerListProduk()
    }

    private fun showRecyclerList() {
        rvKategori.layoutManager = GridLayoutManager(this,4)
        val listKategoriAdapter = ListKategoriAdapter(list)
        rvKategori.adapter = listKategoriAdapter
    }
    private fun showRecyclerListProduk() {
        rvProduk.layoutManager = LinearLayoutManager(this)
        val listProdukAdapter = ListProdukAdapter(listProduk)
        rvProduk.adapter = listProdukAdapter
    }
}