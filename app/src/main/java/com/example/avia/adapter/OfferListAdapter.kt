package com.example.avia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.avia.R
import com.example.avia.databinding.ItemOfferBinding
import com.example.avia.databinding.LayoutFlightBinding
import com.example.avia.model.entity.Offer

class OfferListAdapter : RecyclerView.Adapter<OfferListAdapter.ViewHolder>() {

    private val items: ArrayList<Offer> = arrayListOf()

    fun setItems(offerList: List<Offer>) {
        items.clear()
        items.addAll(offerList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemOfferBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(
        private val binding: ItemOfferBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(offer: Offer) {
            offer.flights.forEach {
                binding.flightsLayout.addView(
                    createFlightView(it, binding.root)
                )
            }
        }

        private fun createFlightView(
            flight: Offer.Flight,
            parent: ViewGroup
        ) = LayoutFlightBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ).apply {
            departureTime.text = flight.departureTimeInfo.timeStr
            arrivalTime.text = flight.arrivalTimeInfo.timeStr
            route.text = parent.context.getString(
                R.string.route_fmt,
                flight.departureLocation.code,
                flight.arrivalLocation.code
            )
            duration.text = parent.context.getString(
                R.string.time_fmt,
                getTimeFormat(flight.duration).first.toString(),
                getTimeFormat(flight.duration).second.toString()
            )
            direct.text = parent.context.getString(R.string.direct)
        }.root

        private fun getTimeFormat(minutes: Int): Pair<Int, Int> = Pair(
            first = minutes / 60,
            second = minutes % 60
        )

    }
}