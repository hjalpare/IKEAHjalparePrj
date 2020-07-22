package edu.uc.kansakpb.ikeahjalpare3.dao

import edu.uc.kansakpb.ikeahjalpare3.dto.Furniture
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

interface IFurnitureDAO {

    @GET("/ikeafurniture.json")
    fun getAllFurnitures(): Call<ArrayList<Furniture>>

    @GET("/ikeafurniture.json")
    fun getFurniture(@Query("furniture_name")funritureName: String): Call <ArrayList<Furniture>>

    // Website for .json feed: https://ikeafurnituredb.s3.us-east-2.amazonaws.com/ikeafurniture.json
}