package com.easyprog.cards.fragments.cards_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.easyprog.cards.data.models.CardsEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CardsListViewModel @Inject constructor(
    private val repository: CardsListRepository
): ViewModel() {

    val listOfCards: LiveData<List<CardsEntity>> = repository.getDataFromLocalStorage()
}