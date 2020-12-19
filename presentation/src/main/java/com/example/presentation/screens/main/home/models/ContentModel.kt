package com.example.presentation.screens.main.home.models

sealed class ContentModel(
    val id: String,
    val nameMain: String,
    val nameSecond: String,
    val imageURL: String
) : BaseModel() {
    class SmallContentModel(id: String, nameMain: String, nameSecond: String, imageURL: String) :
        ContentModel(id, nameMain, nameSecond, imageURL)

    class BigContentModel(id: String, nameMain: String, nameSecond: String, imageURL: String) :
        ContentModel(id, nameMain, nameSecond, imageURL)

    class PlateContentModel(id: String, nameMain: String, nameSecond: String, imageURL: String) :
        ContentModel(id, nameMain, nameSecond, imageURL)
}
