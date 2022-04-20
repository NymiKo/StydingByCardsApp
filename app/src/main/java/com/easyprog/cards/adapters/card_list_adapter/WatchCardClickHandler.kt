package com.easyprog.cards.adapters.card_list_adapter

import com.easyprog.cards.adapters.card_list_adapter.view.CardsView

interface WatchCardClickHandler {
    fun onCardClick(card: CardsView)
}