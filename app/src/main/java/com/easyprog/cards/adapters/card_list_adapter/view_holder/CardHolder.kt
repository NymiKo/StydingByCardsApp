package com.easyprog.cards.adapters.card_list_adapter.view_holder

import com.easyprog.cards.adapters.card_list_adapter.WatchCardClickHandler
import com.easyprog.cards.adapters.card_list_adapter.view.CardsView

interface CardHolder {
    fun setupCardView(view: CardsView)
    fun onAttach(view: CardsView)
    fun onDetach()
}