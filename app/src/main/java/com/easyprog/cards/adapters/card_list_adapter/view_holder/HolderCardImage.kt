package com.easyprog.cards.adapters.card_list_adapter.view_holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.easyprog.cards.adapters.card_list_adapter.WatchCardClickHandler
import com.easyprog.cards.adapters.card_list_adapter.view.CardsView
import com.easyprog.cards.databinding.CardItemImageBinding
import com.easyprog.cards.helpers.setImage

class HolderCardImage(private val binding: CardItemImageBinding): RecyclerView.ViewHolder(binding.root), CardHolder {

    override fun setupCardView(view: CardsView) {
        binding.cardImage.setImage(view.fileUrl)
    }

    override fun onAttach(view: CardsView) {
    }

    override fun onDetach() {
    }
}