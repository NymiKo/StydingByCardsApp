package com.easyprog.cards.adapters.card_list_adapter.view

data class ViewCardImage(
    override val id: Int,
    override val fileUrl: String,
    override val question: String = ""
): CardsView {
    override fun getTypeView(): Int {
        return CardsView.CARD_IMAGE
    }
}
