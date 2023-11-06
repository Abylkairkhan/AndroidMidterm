package com.example.avia.fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.avia.model.entity.Offer
import com.example.avia.model.entity.OfferList
import com.example.avia.model.service.MainService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class OfferListViewModel() : ViewModel() {

    private val service = MainService()

    private val _flightList = MutableLiveData<OfferList>()
    val flightList: LiveData<OfferList>
        get() = _flightList

    fun fetchFlights() {
        viewModelScope.launch(Dispatchers.IO) {
            _flightList.postValue(service.getData())
        }
    }

    fun sortCheapest() {
        _flightList.value!!.offerList
            .let { offers ->
                val sortedOffers = offers.sortedBy { it.price }
                val sortedOfferList = OfferList(sortedOffers as MutableList<Offer>)
                _flightList.postValue(sortedOfferList)
            }
    }

    fun sortDuration() {
        _flightList.value!!.offerList
            .let { offers ->
                val sortedOffers = offers.sortedBy { it.flights.first().duration }
                val sortedOfferList = OfferList(sortedOffers as MutableList<Offer>)
                _flightList.postValue(sortedOfferList)
            }
    }

    fun sortDepartureLatest() {
        Log.d("MyLog", "New one")
        _flightList.value!!.offerList
            .let { offers ->
                val sortedOffers =
                    offers.sortedByDescending { it.flights.first().departureTimeInfo.timeStr }
                val sortedOfferList = OfferList(sortedOffers as MutableList<Offer>)
                _flightList.value = sortedOfferList
            }
    }

    fun sortDepartureEarliest() {
        _flightList.value!!.offerList
            .let { offers ->
                val sortedOffers = offers.sortedBy { it.flights.first().departureTimeInfo.timeStr }
                val sortedOfferList = OfferList(sortedOffers as MutableList<Offer>)
                _flightList.postValue(sortedOfferList)
            }
    }
}