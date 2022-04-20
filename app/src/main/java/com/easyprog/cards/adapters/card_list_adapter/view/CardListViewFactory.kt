package com.easyprog.cards.adapters.card_list_adapter.view

import com.easyprog.cards.data.models.CardModel
import com.easyprog.cards.data.models.CardsEntity
import com.easyprog.cards.helpers.TYPE_CARD_IMAGE
import com.easyprog.cards.helpers.TYPE_CARD_TEXT

class CardListViewFactory {
    companion object {
        fun getView(cardModel: CardsEntity): CardsView {
            return when(cardModel.type) {
                TYPE_CARD_IMAGE -> ViewCardImage(cardModel.id_card, cardModel.fileUrl)
                TYPE_CARD_TEXT -> ViewCardText(cardModel.id_card, cardModel.question)
                else -> ViewCardTextAndImage(cardModel.id_card, cardModel.question, cardModel.fileUrl)
            }
        }
    }
}