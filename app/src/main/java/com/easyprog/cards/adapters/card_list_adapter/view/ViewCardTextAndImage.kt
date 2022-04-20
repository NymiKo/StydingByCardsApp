package com.easyprog.cards.adapters.card_list_adapter.view

data class ViewCardTextAndImage(
    override val id: Int,
    override val question: String,
    override val fileUrl: String
): CardsView {
    override fun getTypeView(): Int {
        return CardsView.CARD_TEXT_AND_IMAGE
    }
}
