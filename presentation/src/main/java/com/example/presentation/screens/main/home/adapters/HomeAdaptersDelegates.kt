package com.example.presentation.screens.main.home.adapters

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.presentation.R
import com.example.presentation.databinding.ItemContentBigBinding
import com.example.presentation.databinding.ItemContentPlateBinding
import com.example.presentation.databinding.ItemContentSmallBinding
import com.example.presentation.databinding.ItemGenreBinding
import com.example.presentation.screens.main.home.models.*
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateLayoutContainer
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun listAdapterDelegate() =
    adapterDelegateLayoutContainer<BaseModelImpl, BaseModel>(R.layout.item_list) {
        val adapter = ListDelegationAdapter(
            genreAdapterDelegate(),
            smallAdapterDelegate(),
            bigAdapterDelegate(),
            plateAdapterDelegate()
        )
        bind {
            findViewById<RecyclerView>(R.id.rvList).adapter = adapter
            findViewById<TextView>(R.id.tvCategory).text = item.categoryModel.category
            adapter.items = item.getList()
            adapter.notifyDataSetChanged()
        }
    }

fun genreAdapterDelegate() =
    adapterDelegateViewBinding<GenreModel, BaseModel, ItemGenreBinding>({ inflater, root ->
        ItemGenreBinding.inflate(inflater, root, false)
    }) {
        bind {
            binding.apply {
                genreBackground.setBackgroundColor(item.backgroundColor)
                tvGenre.text = item.genre
            }
        }
    }

fun smallAdapterDelegate() =
    adapterDelegateViewBinding<ContentModel.SmallContentModel, BaseModel, ItemContentSmallBinding>({ inflater, root ->
        ItemContentSmallBinding.inflate(inflater, root, false)
    }) {
        bind {
            Glide.with(binding.root.context).load(item.imageURL).into(binding.ivAlbum)
            binding.apply {
                tvNameMain.text = item.nameMain
                tvNameSecondary.text = item.nameSecond
            }
        }
    }

fun bigAdapterDelegate() =
    adapterDelegateViewBinding<ContentModel.BigContentModel, BaseModel, ItemContentBigBinding>({ infater, root ->
        ItemContentBigBinding.inflate(infater, root, false)
    }) {
        bind {
            binding.apply {
                Glide.with(root.context).load(item.imageURL).into(ivAlbum)
                tvNameMain.text = item.nameMain
                tvNameSecondary.text = item.nameSecond
            }

        }
    }

fun plateAdapterDelegate() =
    adapterDelegateViewBinding<ContentModel.PlateContentModel, BaseModel, ItemContentPlateBinding>({ infater, root ->
        ItemContentPlateBinding.inflate(infater, root, false)
    }) {
        bind {
            binding.apply {
                Glide.with(root.context).load(item.imageURL).into(ivPlate)
                tvNameMain.text = item.nameMain
                tvNameSecondary.text = item.nameSecond
            }

        }
    }
