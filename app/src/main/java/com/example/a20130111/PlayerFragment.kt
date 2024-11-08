package com.example.a20130111

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a20130111.databinding.FragmentPlayerBinding

class PlayerFragment : Fragment() {
    private lateinit var binding: FragmentPlayerBinding
    private lateinit var viewModel: PlayerDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_player, container, false)
        binding = FragmentPlayerBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity())[PlayerDetailViewModel::class.java]

        val dataset = arrayOf(Data.Faker, Data.Oner, Data.Gumayushi, Data.Keria, Data.Zues)
        val customAdapter = CustomAdapter(dataset) {
            viewModel.addName(it.playedName)
            findNavController().navigate(R.id.action_playerFragment_to_playerProfileFragment)
        }

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = customAdapter

        return view

    }

}