package com.hector.nailnewcomponents.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.hector.nailnewcomponents.R
import com.hector.nailnewcomponents.adapters.FlightAdapter
import com.hector.nailnewcomponents.listeners.RecyclerFlightListener
import com.hector.nailnewcomponents.models.Flight
import com.hector.nailnewcomponents.toast
import kotlinx.android.synthetic.main.fragment_departures.view.*


// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class DeparturesFragment : Fragment() {

    private val list: ArrayList<Flight> by lazy { getFlights() } //By lazy.. When this variable is call one time, his function inside brackets is run, but never is call, never run

    private lateinit var recycler: RecyclerView

    private lateinit var adapter: FlightAdapter

    private val layoutManager by lazy { LinearLayoutManager(context) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.setTitle(R.string.departures_fragment_title)
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_departures, container, false)

        recycler = rootView.recyclerView as RecyclerView
        setRecyclerView()

        return rootView
    }

    private fun setRecyclerView() {
        //Preparing recycler view
        recycler.setHasFixedSize(true)
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.layoutManager = layoutManager
        adapter = (FlightAdapter(list, object: RecyclerFlightListener {
            override fun onClick(flight: Flight, position: Int) {
                activity?.toast("Let's go ${flight.city}!")
            }

            override fun onDelete(flight: Flight, position: Int) {
                list.remove(flight)
                adapter.notifyItemRemoved(position)
                activity?.toast("${flight.city} has been removed!")
            }

        }))
        recycler.adapter = adapter
    }

    private fun getFlights(): ArrayList<Flight>{
        return object: ArrayList<Flight>(){
            init {
                add(Flight(1, "City One!", R.drawable.city_1))
                add(Flight(1, "City Two!", R.drawable.city_2))
                add(Flight(1, "City Three!", R.drawable.city_3))
                add(Flight(1, "City Four!", R.drawable.city_4))
                add(Flight(1, "City Five!", R.drawable.city_5))
            }
        }
    }

}
