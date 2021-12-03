package com.fatah.leadershipapp

import androidx.annotation.DrawableRes

data class Content (
    val title: String,
    val publisher: String,
    @DrawableRes val publisherIcon: Int,
    val time: String,
    val liked: Boolean,
    val image: String
)