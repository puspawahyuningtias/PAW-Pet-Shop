package com.puspawahyuningtias.paw

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.os.Parcelable
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_scrolling.*

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MYDATA = "extra_mydata"
    }
    inline fun <reified T : Parcelable> Activity.getParcelableExtra(key: String) = lazy {
        intent.getParcelableExtra<T>(key)
    }
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(findViewById(R.id.toolbar))

        val produk by getParcelableExtra<Produk>(EXTRA_MYDATA)

        supportActionBar?.title = produk?.name.toString()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val harga = produk?.harga.toString()
        tv_harga.text = "Rp. $harga"
        tv_jenis.text = produk?.jenis.toString()
        tv_kategori.text = produk?.kategori.toString()
        tv_detail_description.text = produk?.deskripsi.toString()
        Glide.with(this)
            .load(produk?.photo.toString())
            .apply(RequestOptions().override(700, 700))
            .into(iv_detail_photo_produk)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}