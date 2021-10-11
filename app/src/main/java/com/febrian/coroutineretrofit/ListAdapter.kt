package com.febrian.coroutineretrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.febrian.coroutineretrofit.databinding.ItemListBinding

class ListAdapter(private val response: ArrayList<Responses>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(response: Responses) {
            binding.title.text = response.title.toString()
            Glide.with(itemView).load(response.thumb).into(binding.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(response[position])
    }

    override fun getItemCount(): Int {
        return response.size
    }
}