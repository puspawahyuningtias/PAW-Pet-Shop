package com.puspawahyuningtias.paw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvProduk: RecyclerView
    private var listProduk: ArrayList<Produk> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvProduk = findViewById(R.id.rv_produk)
        rvProduk.setHasFixedSize(true)

        listProduk.addAll(ProdukData.listData)
        showRecyclerList()
    }
    private fun showRecyclerList() {
        rvProduk.layoutManager = LinearLayoutManager(this)
        val listProdukAdapter = ListProdukAdapter(listProduk)
        rvProduk.adapter = listProdukAdapter
    }
}