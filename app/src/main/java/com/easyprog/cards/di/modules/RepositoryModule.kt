package com.easyprog.cards.di.modules

import com.easyprog.cards.data.dao.CardsDao
import com.easyprog.cards.fragments.cards_list.CardsListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideCardsListRepository(localDataSource: CardsDao) = CardsListRepository(localDataSource)
}