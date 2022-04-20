package com.easyprog.cards.adapters.card_list_adapter.view_holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.easyprog.cards.R
import com.easyprog.cards.adapters.card_list_adapter.WatchCardClickHandler
import com.easyprog.cards.adapters.card_list_adapter.view.CardsView
import com.easyprog.cards.databinding.CardItemImageBinding
import com.easyprog.cards.databinding.CardItemTextAndImageBinding
import com.easyprog.cards.databinding.CardItemTextBinding

class CardListHolderFactory {
    companion object {
        fun getHolder(viewGroup: ViewGroup, viewType: Int, listener: WatchCardClickHandler): RecyclerView.ViewHolder {
            return when(viewType){
                CardsView.CARD_IMAGE -> {
                    val binding = CardItemImageBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
                    HolderCardImage(binding)
                }

                CardsView.CARD_TEXT -> {
                    val binding = CardItemTextBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
                    HolderCardText(binding, listener)
                }

                else -> {
                    val binding = CardItemTextAndImageBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
                    HolderCardImageAndText(binding)
                }
            }
        }
    }
}