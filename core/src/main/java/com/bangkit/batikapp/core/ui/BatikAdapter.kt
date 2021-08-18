package com.bangkit.batikapp.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.batikapp.core.R
import com.bangkit.batikapp.core.domain.model.Batik
import com.bangkit.batikapp.core.databinding.ItemListBatikBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.ArrayList

class BatikAdapter : RecyclerView.Adapter<BatikAdapter.ListViewHolder>() {

    private var listData = ArrayList<Batik>()
    var onItemClick: ((Batik) -> Unit)? = null

    fun setData(newListData: List<Batik>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_batik, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListBatikBinding.bind(itemView)

        fun bind(data: Batik) {
            val posterUrl = "https://image.tmdb.org/t/p/original/${data.posterPath}"

            with(binding) {
                Glide.with(itemView.context)
                    .load(posterUrl)
                    .apply(RequestOptions.placeholderOf(R.drawable.loading).error(R.drawable.error))
                    .into(ivItemImage)
                tvItemTitle.text = data.originalTitle
                tvItemSubtitle.text = data.releaseDate
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}