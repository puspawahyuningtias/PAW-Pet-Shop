package com.puspawahyuningtias.paw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvKategori: RecyclerView
    private var list: ArrayList<kategori> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvKategori = findViewById(R.id.rv_kategori)
        rvKategori.setHasFixedSize(true)

        list.addAll(KategoriData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvKategori.layoutManager = GridLayoutManager(this,4)
        val listHeroAdapter = ListKategoriAdapter(list)
        rvKategori.adapter = listHeroAdapter
    }
}