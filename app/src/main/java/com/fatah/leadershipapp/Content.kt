package com.fatah.leadershipapp

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Content (
    val title: String,
    val publisher: String,
    @DrawableRes val publisherIcon: Int,
    val publisherIconBackground: Color,
    val time: String,
    val liked: Boolean,
    val image: String,
    val background: Color
)