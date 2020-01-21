package com.example.ghentparking.ui.parkings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ghentparking.R
import com.example.ghentparking.databinding.FragmentParkingsBinding

class ParkingsFragment : Fragment() {

    private lateinit var parkingsViewModel: ParkingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        parkingsViewModel =
            ViewModelProviders.of(this).get(ParkingsViewModel::class.java)

        val binding: FragmentParkingsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_parkings, container, false)

        binding.lifecycleOwner = this
        binding.parkingsViewModel = parkingsViewModel

        val adapter = ParkingsAdapter()

        binding.parkingsList.adapter = adapter
        binding.parkingsList.layoutManager = LinearLayoutManager(this.context)

        initializeParkings()
        observeRefresh(binding)

        return binding.root
    }

    private fun initializeParkings() {
        parkingsViewModel.getParkings()
    }

    private fun observeRefresh(binding: FragmentParkingsBinding) {
        binding.swiperefresh.setOnRefreshListener {
            initializeParkings()
            binding.swiperefresh.isRefreshing = false
        }
    }
}