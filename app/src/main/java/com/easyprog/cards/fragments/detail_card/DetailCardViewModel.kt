package com.easyprog.cards.fragments.detail_card

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.easyprog.cards.data.models.CardsEntity
import com.easyprog.cards.fragments.create_card.CreateCardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class DetailCardViewModel @Inject constructor(
    private val repository: DetailCardRepository
): ViewModel() {

    private val _card = MutableLiveData<CardsEntity>()
    val card: LiveData<CardsEntity> = _card

    fun getCard(id: Int?) = viewModelScope.launch {
        if(id != null) {
            _card.value = repository.getCard(id).await()
        }
    }

}