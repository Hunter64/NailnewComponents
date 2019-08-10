package com.hector.nailnewcomponents.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.hector.nailnewcomponents.R
import com.hector.nailnewcomponents.adapters.FlightAdapter
import com.hector.nailnewcomponents.models.Flight


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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_departures, container, false)
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
