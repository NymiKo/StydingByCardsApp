package com.easyprog.cards.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.easyprog.cards.data.contract.RoomContract

@Entity(tableName = RoomContract.tableCards)
data class CardsEntity (
    @PrimaryKey(autoGenerate = true)
    var id_card: Int = 0,
    val question: String,
    val answer: String,
    val fileUrl: String,
    val type: String
)