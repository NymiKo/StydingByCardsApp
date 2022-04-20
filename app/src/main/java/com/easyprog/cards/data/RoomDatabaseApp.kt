package com.easyprog.cards.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.easyprog.cards.data.contract.RoomContract
import com.easyprog.cards.data.dao.CardsDao
import com.easyprog.cards.data.models.CardsEntity

@Database(entities = [CardsEntity::class], version = 1, exportSchema = false)
abstract class RoomDatabaseApp : RoomDatabase() {
    abstract fun cardsDao(): CardsDao

    companion object {

        @Volatile private var instance: RoomDatabaseApp? = null

        fun getDatabase(context: Context): RoomDatabaseApp = instance ?: synchronized(this) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, RoomDatabaseApp::class.java, RoomContract.databaseApp)
                .fallbackToDestructiveMigration()
                .build()
    }
}