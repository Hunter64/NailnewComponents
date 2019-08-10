package com.hector.nailnewcomponents.listeners

import com.hector.nailnewcomponents.models.Flight

interface RecyclerFlightListener{
    fun onClick(flight: Flight, position: Int)
    fun onDelete(flight: Flight, position: Int)
}