package com.easyprog.cards.adapters.card_list_adapter.view_holder

import androidx.recyclerview.widget.RecyclerView
import com.easyprog.cards.adapters.card_list_adapter.WatchCardClickHandler
import com.easyprog.cards.adapters.card_list_adapter.view.CardsView
import com.easyprog.cards.databinding.CardItemTextAndImageBinding
import com.easyprog.cards.helpers.setImage

class HolderCardImageAndText(private val binding: CardItemTextAndImageBinding): RecyclerView.ViewHolder(binding.root), CardHolder {
    override fun setupCardView(view: CardsView) {
        binding.cardText.text = view.question
        //binding.cardImage.setImage(view.fileUrl)
    }

    override fun onAttach(view: CardsView) {
    }

    override fun onDetach() {
    }
}