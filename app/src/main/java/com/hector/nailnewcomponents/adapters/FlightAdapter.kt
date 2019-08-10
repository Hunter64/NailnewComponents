package com.hector.nailnewcomponents.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hector.nailnewcomponents.R
import com.hector.nailnewcomponents.inflate
import com.hector.nailnewcomponents.listeners.RecyclerFlightListener
import com.hector.nailnewcomponents.loadByResource
import com.hector.nailnewcomponents.models.Flight
import kotlinx.android.synthetic.main.recycler_flight.view.*

class FlightAdapter (private val flights: List<Flight>, private val listener: RecyclerFlightListener): RecyclerView.Adapter<FlightAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.recycler_flight))

    override fun getItemCount() = flights.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(flights[position], listener)

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(flight: Flight, listener: RecyclerFlightListener) = with(itemView){
            //When is bind, in with(itemView) -> is context that is inside brackets, if we don't put itemView, we need put for each item -> itemView.textViewCityName.text = flight.city
            textViewCityName.text = flight.city
            imageViewBg.loadByResource(flight.imgResource)

            //Clicks Events
            setOnClickListener { listener.onClick(flight, adapterPosition) }

            buttonDelete.setOnClickListener { listener.onDelete(flight, adapterPosition) }
        }
    }
}