package com.easyprog.cards.fragments.create_card

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CreateCardViewModel @Inject constructor(
    private val repository: CreateCardRepository
) : ViewModel() {

    private val _statusCard = MutableLiveData<String>()
    val statusCard: LiveData<String> = _statusCard

    suspend fun saveCard(question: String, answer: String, type: String, fileUrl: String) {
        repository.saveCard(question = question, answer = answer, fileUrl = fileUrl, type = type)
        _statusCard.value = "Success"
    }
}