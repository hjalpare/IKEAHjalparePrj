package edu.uc.kansakpb.ikeahjalpare3

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientInstance {
    private var retrofit: Retrofit? = null;
    // json file to search IKEA: http://www.ikea.com/us/en/iows/catalog/availability/12345678 replace: https://api.npoint.io
    private val BASE_URL = "http://www.ikea.com"

    val retrofitInstance : Retrofit?
        get() {
            // has this object been created
            if (retrofit == null) {
                //create it
                retrofit = retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}