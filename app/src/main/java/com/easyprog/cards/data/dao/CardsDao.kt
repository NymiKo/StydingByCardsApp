package com.easyprog.cards.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.easyprog.cards.data.contract.RoomContract
import com.easyprog.cards.data.models.CardModel
import com.easyprog.cards.data.models.CardsEntity
import kotlinx.coroutines.Deferred

@Dao
interface CardsDao {

    @Query("SELECT * FROM ${RoomContract.tableCards}")
    fun fetchCards(): LiveData<List<CardsEntity>>

    @Query("SELECT * FROM ${RoomContract.tableCards} WHERE id_card = :id")
    fun getCard(id: Int): CardsEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCard(cardsEntity: CardsEntity)
}