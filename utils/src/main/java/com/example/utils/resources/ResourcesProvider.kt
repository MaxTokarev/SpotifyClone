package com.example.utils.resources

import android.content.Context
import android.content.res.Resources
import com.example.utilities.resources.IResourcesProvider

class ResourcesProvider(private val context: Context): IResourcesProvider {
    override fun getResources(): Resources {
        return context.resources
    }

    override fun getString(stringId: Int): String {
        return context.resources.getString(stringId)
    }
}