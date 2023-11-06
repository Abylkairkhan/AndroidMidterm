package com.example.avia.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.avia.adapter.OfferListAdapter
import com.example.avia.databinding.FragmentOfferListBinding


class OfferListFragment : Fragment() {

    companion object {
        fun newInstance() = OfferListFragment()
    }

    private var _binding: FragmentOfferListBinding? = null
    private val binding
        get() = _binding!!

    private val adapter: OfferListAdapter by lazy {
        OfferListAdapter()
    }

    private val viewModel: OfferListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOfferListBinding.inflate(layoutInflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        viewModel.fetchFlights()

        viewModel.flightList.observe(viewLifecycleOwner) {
            adapter.setItems(viewModel.flightList.value!!.offerList)
            binding.progressBar.visibility = View.INVISIBLE
        }
    }

    private fun setupUI() {
        with(binding) {
            offerList.adapter = adapter
            sort.setOnClickListener {
                SortBottomSheetFragment.newInstance(viewModel).also {
                    it.show(childFragmentManager, it.javaClass.toString())
                }
            }
        }
    }
}