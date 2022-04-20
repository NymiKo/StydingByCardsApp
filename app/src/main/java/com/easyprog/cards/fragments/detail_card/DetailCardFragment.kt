package com.easyprog.cards.fragments.detail_card

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.view.marginStart
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.easyprog.cards.R
import com.easyprog.cards.databinding.FragmentDialogDetailCardBinding
import com.google.android.material.card.MaterialCardView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailCardFragment : DialogFragment() {

    private var _binding: FragmentDialogDetailCardBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<DetailCardViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDialogDetailCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setParamsDialog()
        getCard()
        setupView()
    }

    private fun setupView() {
        //get card
        viewModel.card.observe(viewLifecycleOwner, Observer { card ->
            binding.textCardQuestion.text = card.question
            binding.textCardAnswer.text = card.answer
        })
    }

    private fun getCard() {
        val id = arguments?.getInt(getString(R.string.id_card))
        viewModel.getCard(id)
    }

    private fun setParamsDialog() {
        val window = dialog?.window ?: return
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        val background = ColorDrawable(Color.TRANSPARENT)
        val inset = InsetDrawable(background, 36, 0, 36, 0)
        window.setBackgroundDrawable(inset)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}