package edu.uc.kansakpb.ikeahjalpare3.dao

import edu.uc.kansakpb.ikeahjalpare3.dto.Furniture
import retrofit2.http.GET
import retrofit2.Call

interface IFurnitureDAO {
    //DAO class: Extracts json feed
    @GET("/ikeafurniture.json")
    fun getAllFurnitures(): Call<ArrayList<Furniture>>
}