package com.example.recyclerview_grid

import Image
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_grid.databinding.ItemImageBinding
import com.squareup.picasso.Picasso

typealias OnClickDisaster = (Image) -> Unit

class ImageAdapter(private val listDisaster: List<Image>, private val onClickDisaster: OnClickDisaster): RecyclerView.Adapter<ImageAdapter.ItemDisasterViewHolder>() {
    inner class ItemDisasterViewHolder(private val binding: ItemImageBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: Image){
            with(binding){
                Picasso.get()
                    .load(data.imgSource)
                    .into(imgItem)

                imgItem.setOnClickListener{
                    onClickDisaster(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDisasterViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemDisasterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listDisaster.size
    }

    override fun onBindViewHolder(holder: ItemDisasterViewHolder, position: Int) {
        holder.bind(listDisaster[position])
    }
}