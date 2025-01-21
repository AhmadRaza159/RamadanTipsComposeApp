package com.example.learningramadantipscomposeapp.data.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class RamadanDay(
    @StringRes val dayNumTitle:Int,
    @StringRes val dayQuoteTitle:Int,
    @DrawableRes val dayImage:Int,
    @StringRes val dayQuoteDesc:Int
)
