package com.easyprog.cards.adapters.card_list_adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.easyprog.cards.adapters.card_list_adapter.view.CardsView
import com.easyprog.cards.adapters.card_list_adapter.view_holder.CardHolder
import com.easyprog.cards.adapters.card_list_adapter.view_holder.CardListHolderFactory

class CardsListAdapter(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mListCards = mutableListOf<CardsView>()
    private val mListHolders = mutableListOf<CardHolder>()

    private var cardClickHandler: WatchCardClickHandler? = null

    fun getData(list: ArrayList<CardsView>) {
        mListCards.clear()
        mListCards.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CardListHolderFactory.getHolder(parent, viewType, cardClickHandler!!)
    }

    override fun getItemViewType(position: Int): Int {
        return mListCards[position].getTypeView()
    }

    override fun getItemCount(): Int = mListCards.size

    fun attachClickHandler(click: WatchCardClickHandler) {
        this.cardClickHandler = click
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CardHolder).setupCardView(mListCards[position])
    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        (holder as CardHolder).onAttach(mListCards[holder.adapterPosition])
        mListHolders.add((holder as CardHolder))
        super.onViewAttachedToWindow(holder)
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        (holder as CardHolder).onDetach()
        mListHolders.remove((holder as CardHolder))
        super.onViewDetachedFromWindow(holder)
    }

    fun addItem(item: CardsView){
        if(!mListCards.contains(item)) {
            mListCards.add(item)
            mListCards.sortByDescending { it.id }
            notifyItemInserted(0)
        }
    }

    fun onDestroy() {
        mListHolders.forEach {
            it.onDetach()
        }
    }
}