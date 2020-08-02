package edu.uc.kansakpb.ikeahjalpare3.ui.main

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {
    private var retrofit: Retrofit? = null
    private val BASE_URL = "https://ikeafurnituredb.s3.us-east-2.amazonaws.com"

    val retrofitInstance : Retrofit?
        get() {
            // has this object been created
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}