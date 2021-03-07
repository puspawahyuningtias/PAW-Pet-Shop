package com.puspawahyuningtias.paw

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListKategoriAdapter(private val listKategori: ArrayList<kategori>) :
    RecyclerView.Adapter<ListKategoriAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var icon: ImageView = itemView.findViewById(R.id.icon_kategori)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_kategori, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val kategori = listKategori[position]
        Glide.with(holder.itemView.context)
            .load(kategori.icon)
            .apply(RequestOptions().override(35, 35))
            .into(holder.icon)
        holder.tvName.text = kategori.name
    }

    override fun getItemCount(): Int {
        return listKategori.size
    }
}