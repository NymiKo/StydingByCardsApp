package com.easyprog.cards.fragments.cards_list

import androidx.lifecycle.LiveData
import com.easyprog.cards.data.dao.CardsDao
import com.easyprog.cards.data.models.CardModel
import com.easyprog.cards.data.models.CardsEntity
import com.easyprog.cards.helpers.TYPE_CARD_IMAGE
import com.easyprog.cards.helpers.TYPE_CARD_IMAGE_AND_TEXT
import com.easyprog.cards.helpers.TYPE_CARD_TEXT
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import javax.inject.Inject

class CardsListRepository @Inject constructor(
    private val localDataSource: CardsDao
) {

    fun getDataFromLocalStorage(): LiveData<List<CardsEntity>> {
        return localDataSource.fetchCards()
    }

}