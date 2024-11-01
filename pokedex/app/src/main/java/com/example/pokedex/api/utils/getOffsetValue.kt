package com.example.pokedex.api.utils

import android.net.Uri

fun getOffsetValue(url: String): String? {
    val uri = Uri.parse(url)
    return uri.getQueryParameter("offset")
}