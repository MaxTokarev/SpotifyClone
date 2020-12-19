package com.example.presentation.screens.main.home.models

data class BaseModelImpl(
    val categoryModel: CategoryModel,
    val genreModel: List<GenreModel>? = null,
    val smallContentModel: List<ContentModel.SmallContentModel>? = null,
    val bigContentModel: List<ContentModel.BigContentModel>? = null,
    val plateContentModel: List<ContentModel.PlateContentModel>? = null,
) : BaseModel()

fun BaseModelImpl.getList(): List<BaseModel> {
    val list = mutableListOf(genreModel, smallContentModel, bigContentModel, plateContentModel)
    var yep = listOf<BaseModel>()
    list.forEach { if (it != null) yep = it }
    return yep
}
