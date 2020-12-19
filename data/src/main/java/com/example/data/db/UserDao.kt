package com.example.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Single

@Dao
interface UserDao {
    @Query("SELECT * FROM userTable WHERE id = :userId")
    fun getUser(userId: String): Single<UserEntity>

    @Query("SELECT * FROM userTable")
    fun getAllUsers(): Single<List<UserEntity>>

    @Insert
    fun insertUser(user: UserEntity)

    @Delete
    fun deleteUser(user: UserEntity)

}