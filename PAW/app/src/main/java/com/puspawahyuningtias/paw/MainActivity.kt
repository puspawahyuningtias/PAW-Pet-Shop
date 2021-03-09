package com.puspawahyuningtias.paw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
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
        val listProdukAdapter = ListProdukAdapter(listProduk, this@MainActivity)
        rvProduk.adapter = listProdukAdapter
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_about -> {
            val intent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(intent)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}