package com.example.data.network

import com.example.data.db.UserEntity
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AuthApi {
    @GET("authorize")
    fun authorizeAccount(
        @Query("client_id") clientId: String,
        @Query("response_type") responseType: String,
        @Query("redirect_uri") redirectUri: String
    ): Single<UserEntity>
}