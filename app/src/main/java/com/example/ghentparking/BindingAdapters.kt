package com.example.ghentparking

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ghentparking.ui.parkings.Parking
import com.example.ghentparking.ui.parkings.ParkingsAdapter

class BindingAdapters {
    companion object{

        @BindingAdapter("bind:parkingsListData")
        @JvmStatic
        fun bindRecyclerViewParkings(recyclerView: RecyclerView, data: List<Parking>?) {
            val adapter = recyclerView.adapter as ParkingsAdapter
            adapter.submitList(data)
        }
    }
}