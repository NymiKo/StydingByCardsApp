package com.easyprog.cards.di.modules

import android.content.Context
import androidx.room.Room
import com.easyprog.cards.data.RoomDatabaseApp
import com.easyprog.cards.data.contract.RoomContract
import com.easyprog.cards.di.App
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context) = RoomDatabaseApp.buildDatabase(appContext)

    @Provides
    @Singleton
    fun provideCardsDao(db: RoomDatabaseApp) = db.cardsDao()
}