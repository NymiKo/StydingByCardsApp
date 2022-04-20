package com.easyprog.cards.data.converters

import com.easyprog.cards.data.models.CardModel
import com.easyprog.cards.data.models.CardsEntity

class CardsConverter {

    fun fromDBToDomain(cardsEntity: CardsEntity): CardModel {
        return  CardModel(cardsEntity.id_card, cardsEntity.question, cardsEntity.fileUrl, cardsEntity.type)
    }
}