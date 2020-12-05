package com.example.utilities.resources

import android.content.res.Resources
import android.graphics.fonts.Font

interface IResourcesProvider {
    fun getResources(): Resources
    fun getString(stringId: Int): String
}