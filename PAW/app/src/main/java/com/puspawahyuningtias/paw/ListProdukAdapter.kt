package com.puspawahyuningtias.paw

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListProdukAdapter(private val listProduk: ArrayList<Produk>, private val context: Context):
    RecyclerView.Adapter<ListProdukAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_merek)
        var tvHarga: TextView = itemView.findViewById(R.id.tv_harga)
        var tvDeskripsi: TextView = itemView.findViewById(R.id.tv_deskripsi)
        var imgPhotoProduk: ImageView = itemView.findViewById(R.id.img_produk)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_produk, viewGroup, false)
        return ListViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val produk = listProduk[position]
        val harga = produk.harga
        Glide.with(holder.itemView.context)
            .load(produk.photo)
            .apply(RequestOptions().override(60, 60))
            .into(holder.imgPhotoProduk)
        holder.tvName.text = produk.name
        holder.tvDeskripsi.text = produk.deskripsi
        holder.tvHarga.text = "Rp. $harga"
        holder.itemView.setOnClickListener {
            val moveWithObjectIntent = Intent(context, DetailActivity::class.java)
            moveWithObjectIntent.putExtra(DetailActivity.EXTRA_MYDATA, produk)
            context.startActivity(moveWithObjectIntent)
        }
    }

    override fun getItemCount(): Int {
        return listProduk.size
    }
}