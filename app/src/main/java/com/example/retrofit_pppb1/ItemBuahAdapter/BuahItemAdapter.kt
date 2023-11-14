package com.example.retrofit_pppb1.ItemBuahAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit_pppb1.databinding.ItemBuahBinding
import com.example.retrofit_pppb1.model.BuahData

typealias onClickBuah = (BuahData) -> Unit
class BuahItemAdapter (
    private val listBuah: ArrayList<BuahData>,
    private val onClickBuah: onClickBuah
) : RecyclerView.Adapter<BuahItemAdapter.ItemBuahViewHolder>() {

    // ... (Bagian lain dari kelas adapter)

    inner class ItemBuahViewHolder(private val binding: ItemBuahBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data:BuahData) {
            with(binding) {
                txtFilmLazday.text = data.title
                itemView.setOnClickListener {
                    onClickBuah(data) // Memanggil onClickBuah dengan BuahModel, bukan BuahData
                }
                Glide.with(itemView.context).load(data.image).into(binding.imageLazday)
            }
        }
    }

    // ... (Metode lain dari kelas adapter)
    // untuk menyusun yang akan ditampilkan
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemBuahViewHolder
    {
        val binding = ItemBuahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemBuahViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemBuahViewHolder, position: Int) {
        holder.bind(listBuah[position])
    }

    override fun getItemCount(): Int = listBuah.size



}
