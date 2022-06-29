package com.express.android.lwretrofit.retrofit

import com.express.android.lwretrofit.data.CountryModel
import retrofit2.Call
import retrofit2.http.GET

interface RetroServiceInterface {

    @GET("/v2/name/")
    fun getCountryList(): Call<List<CountryModel>>
}