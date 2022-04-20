package com.easyprog.cards.fragments.detail_card

import androidx.lifecycle.LiveData
import com.easyprog.cards.data.dao.CardsDao
import com.easyprog.cards.data.models.CardsEntity
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import javax.inject.Inject

class DetailCardRepository @Inject constructor(
    private val localDataSource: CardsDao
) {

    fun getCard(id: Int): Deferred<CardsEntity> {
        return GlobalScope.async { localDataSource.getCard(id) }
    }

}