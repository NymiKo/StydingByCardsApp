package com.easyprog.cards.helpers

import android.widget.ImageView
import com.easyprog.cards.R
import com.squareup.picasso.Picasso

fun ImageView.setImage(url: String?) {
    Picasso.get().load(url).fit().into(this)
}