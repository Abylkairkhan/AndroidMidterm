package com.example.avia.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.avia.databinding.FragmentSortBottomSheetBinding
import com.example.avia.util.RoundedBottomSheetDialogFragment


class SortBottomSheetFragment : RoundedBottomSheetDialogFragment() {

    companion object {
        fun newInstance() = SortBottomSheetFragment()
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
    }
}