package com.easyprog.cards.fragments.create_card

import android.util.Log
import com.easyprog.cards.data.dao.CardsDao
import com.easyprog.cards.data.models.CardsEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import javax.inject.Inject

class CreateCardRepository @Inject constructor(
    private val localDataSource: CardsDao
) {

    @Suppress("DeferredResultUnused")
    suspend fun saveCard(question: String, answer: String, type: String, fileUrl: String) {
        GlobalScope.async {
            localDataSource.saveCard(
                CardsEntity(
                    question = question,
                    answer = answer,
                    fileUrl = fileUrl,
                    type = type
                )
            )
        }
        Log.e("DATA", CardsEntity(
            question = question,
            answer = answer,
            fileUrl = fileUrl,
            type = type
        ).toString())
    }
}