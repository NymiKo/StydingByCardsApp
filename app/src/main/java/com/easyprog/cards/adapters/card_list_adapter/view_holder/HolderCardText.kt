package com.easyprog.cards.adapters.card_list_adapter.view_holder

import androidx.recyclerview.widget.RecyclerView
import com.easyprog.cards.adapters.card_list_adapter.WatchCardClickHandler
import com.easyprog.cards.adapters.card_list_adapter.view.CardsView
import com.easyprog.cards.databinding.CardItemTextBinding

class HolderCardText(private val binding: CardItemTextBinding, val cardClickListener: WatchCardClickHandler): RecyclerView.ViewHolder(binding.root), CardHolder {

    private var cardClick: WatchCardClickHandler? = null

    override fun setupCardView(view: CardsView) {
        binding.cardText.text = view.question
        binding.btnWatchCard.setOnClickListener {
            cardClick?.onCardClick(view)
        }
    }

    override fun onAttach(view: CardsView) {
        this.cardClick = cardClickListener
    }

    override fun onDetach() {
    }
}