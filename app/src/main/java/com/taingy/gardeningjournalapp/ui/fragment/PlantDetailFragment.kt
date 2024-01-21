package com.taingy.gardeningjournalapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.taingy.gardeningjournalapp.R

class PlantDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.plant_detail_fragment, container, false)

        val plant = arguments?.getStringArray("plant")

        val tvName = view.findViewById<TextView>(R.id.tv_plant_name)
        val tvType = view.findViewById<TextView>(R.id.tv_type)
        val tvFreq = view.findViewById<TextView>(R.id.tv_watering_freq)
        val tvDate = view.findViewById<TextView>(R.id.tv_planting_date)

        tvName.text = plant?.get(0)
        tvType.text = "Type: ${plant?.get(1)}"
        tvFreq.text = "Watering Frequency: ${plant?.get(2)}"
        tvDate.text = "Planting Date: ${plant?.get(3)}"

        return view
    }


}