package com.example.a20130111

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.a20130111.databinding.FragmentPlayerProfileBinding

class PlayerProfileFragment : Fragment() {

    private lateinit var binding: FragmentPlayerProfileBinding
    private lateinit var viewModel: PlayerDetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_player_profile, container, false)
        binding = FragmentPlayerProfileBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity())[PlayerDetailViewModel::class.java]

        val backButton = binding.backButton
        val avatar = binding.avatar
        val playerName = binding.playerName
        val description = binding.description

        val playerDetailMap = mapOf(
            PLayerProfile.Faker.playerName to PLayerProfile.Faker,
            PLayerProfile.Oner.playerName to PLayerProfile.Oner,
            PLayerProfile.Gumayushi.playerName to PLayerProfile.Gumayushi,
            PLayerProfile.Keria.playerName to PLayerProfile.Keria,
            PLayerProfile.Zues.playerName to PLayerProfile.Zues
        )

        viewModel.detail.observe(viewLifecycleOwner) { detail ->
            detail?.let {
                // Check if the nickname exists in the map
                val matchingPlayer = playerDetailMap[detail.nickName]

                if (matchingPlayer != null) {
                    playerName.text = matchingPlayer.playerName
                    avatar.setImageResource(matchingPlayer.contentImage)
                    description.text = getString(matchingPlayer.playerDescription)
                }

            }
        }

        backButton.setOnClickListener {
            requireActivity().onBackPressed()
        }

        return view
    }

}