package com.example.thirtydaysapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Day(

    val day: String,
    @StringRes val affirmation: Int,
    @DrawableRes val image: Int,
    @StringRes val description: Int
)
