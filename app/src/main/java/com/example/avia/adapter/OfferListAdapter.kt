package com.example.avia.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.avia.R
import com.example.avia.databinding.ItemOfferBinding
import com.example.avia.databinding.LayoutFlightBinding
import com.example.avia.model.entity.Offer

class OfferListAdapter : RecyclerView.Adapter<OfferListAdapter.ViewHolder>() {

    private var items: List<Offer> = arrayListOf()

    fun getItems(): List<Offer> {
        return items
    }

    fun setItems(offerList: List<Offer>) {
        val diffUtil = MyDiffUtil(getItems(), offerList)
        val result = DiffUtil.calculateDiff(diffUtil)
        items = offerList
        result.dispatchUpdatesTo(this)
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
                    createFlightView(it, binding.root, offer.price)
                )
            }
        }

        private fun createFlightView(
            flight: Offer.Flight,
            parent: ViewGroup,
            price: Int
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
            priceTextView.text = price.toString() + "₸"
            imgView.load("https://caspiannews.com/media/caspian_news/all_original_photos/1562246491_618507_1562246410_465146547_wide.jpg")
        }.root

        private fun getTimeFormat(minutes: Int): Pair<Int, Int> = Pair(
            first = minutes / 60,
            second = minutes % 60
        )

    }
}