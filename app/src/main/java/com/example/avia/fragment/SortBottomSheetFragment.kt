package com.example.avia.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.avia.adapter.OfferListAdapter
import com.example.avia.databinding.FragmentSortBottomSheetBinding
import com.example.avia.model.entity.OfferList
import com.example.avia.util.RoundedBottomSheetDialogFragment


class SortBottomSheetFragment(
    private val viewModel: OfferListViewModel
) : RoundedBottomSheetDialogFragment() {

    companion object {
        fun newInstance(
            viewModel: OfferListViewModel
        ) = SortBottomSheetFragment(
            viewModel
        )
    }

    private var _binding: FragmentSortBottomSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSortBottomSheetBinding.inflate(layoutInflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sort()
    }

    private fun sort() {
        with(binding) {
            sortCheapest.setOnClickListener {
                viewModel.sortCheapest()
                dismiss()
            }
            sortFastest.setOnClickListener {
                viewModel.sortDuration()
            }
            sortDepartureLatest.setOnClickListener {
                viewModel.sortDepartureLatest()
            }
            sortDepartureEarliest.setOnClickListener {
                viewModel.sortDepartureEarliest()
            }
        }
    }
}