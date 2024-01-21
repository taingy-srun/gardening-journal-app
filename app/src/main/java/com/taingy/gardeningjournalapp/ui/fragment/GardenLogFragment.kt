package com.taingy.gardeningjournalapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.taingy.gardeningjournalapp.R
import com.taingy.gardeningjournalapp.db.Plant
import com.taingy.gardeningjournalapp.viewmodel.GardenLogViewModel

class GardenLogFragment : Fragment() {

    private val samplePlants = mutableListOf<Plant>()

    private lateinit var gardenLogViewModel: GardenLogViewModel

    init {
        samplePlants.add(Plant(name = "Rose", type = "Flower", wateringFrequency = 2, plantingDate = "2023-01-01"))
        samplePlants.add(Plant(name = "Tomato", type = "Vegetable", wateringFrequency = 3, plantingDate = "2023-02-15"))
        samplePlants.add(Plant(name = "Basil", type = "Herb", wateringFrequency = 1, plantingDate = "2023-03-10"))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.garden_log_fragment, container, false)

//        gardenLogViewModel = ViewModelProvider(this).get(GardenLogViewModel::class.java)

        val plantNames = mutableListOf<String>()
        for (plant in samplePlants) {
//            gardenLogViewModel.save(plant)
            plantNames.add(plant.name)
        }

        val listViewPlants = view.findViewById<ListView>(R.id.list_plant)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, plantNames)
        listViewPlants.adapter = adapter


        listViewPlants.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedItem = samplePlants[position]

            val bundle = Bundle().apply {
                putStringArray("plant", arrayOf(selectedItem.name, selectedItem.type, selectedItem.wateringFrequency.toString(), selectedItem.plantingDate))
            }
            findNavController().navigate(R.id.action_gardenLogFragment_to_plantDetailFragment, bundle)
        }
        return view
    }

}