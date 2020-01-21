package com.example.ghentparking.ui.parkings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ghentparking.databinding.FragmentParkingsBinding
import com.example.ghentparking.databinding.ParkingListItemBinding

class ParkingsAdapter() :
    ListAdapter<Parking, ParkingsAdapter.ViewHolder>(ParkingsDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: ParkingListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            item: Parking
        ) {
            binding.parking = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ParkingListItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class ParkingsDiffCallback : DiffUtil.ItemCallback<Parking>() {
        override fun areItemsTheSame(oldItem: Parking, newItem: Parking): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Parking, newItem: Parking): Boolean {
            return oldItem == newItem
        }
    }
}
