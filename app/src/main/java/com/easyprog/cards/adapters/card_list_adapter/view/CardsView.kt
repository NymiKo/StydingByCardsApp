package com.easyprog.cards.adapters.card_list_adapter.view

interface CardsView {
    val id: Int
    val question: String
    val fileUrl: String

    companion object {
        val CARD_IMAGE: Int get() = 0
        val CARD_TEXT: Int get() = 1
        val CARD_TEXT_AND_IMAGE: Int get() = 2
    }

    fun getTypeView(): Int
}