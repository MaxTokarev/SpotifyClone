package com.example.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userTable")
data class UserEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "refresh_token") val refreshToken: String?,
    @ColumnInfo(name = "access_token") val accessToken: String?,
)
