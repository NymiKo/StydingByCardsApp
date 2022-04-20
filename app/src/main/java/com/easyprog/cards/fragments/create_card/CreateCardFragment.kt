package com.easyprog.cards.fragments.create_card

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.easyprog.cards.MainActivity
import com.easyprog.cards.R
import com.easyprog.cards.databinding.FragmentCreateCardBinding
import com.easyprog.cards.helpers.TYPE_CARD_IMAGE
import com.easyprog.cards.helpers.TYPE_CARD_IMAGE_AND_TEXT
import com.easyprog.cards.helpers.TYPE_CARD_TEXT
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateCardFragment : Fragment() {

    private var _binding: FragmentCreateCardBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<CreateCardViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCreateCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setupView()
    }

    private fun setupView() {
        binding.fabSaveCard.setOnClickListener {
            val question = binding.editQuestion.text.toString()
            val answer = binding.editAnswer.text.toString()
            val url = ""

            if(question.isNotEmpty() && url.isEmpty()) {
                viewModel.saveCard(question, answer, TYPE_CARD_TEXT, url)
            } else if (question.isEmpty() && url.isNotEmpty()) {
                viewModel.saveCard(question, answer, TYPE_CARD_IMAGE, url)
            } else viewModel.saveCard(question, answer, TYPE_CARD_IMAGE_AND_TEXT, url)

            observeStatusSaveCard()
        }
    }

    private fun observeStatusSaveCard() {
        viewModel.statusCard.observe(viewLifecycleOwner, Observer {
            when(it) {
                "Success" -> findNavController().popBackStack()
            }
        })
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}