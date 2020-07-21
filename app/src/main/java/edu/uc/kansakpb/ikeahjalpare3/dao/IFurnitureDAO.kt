package edu.uc.kansakpb.ikeahjalpare3.dao

import edu.uc.kansakpb.ikeahjalpare3.dto.Furniture
import retrofit2.http.GET
import retrofit2.Call

interface IFurnitureDAO {
    //Created DAO class for
    @GET("/ikeafurniture.json")
    fun getAllFurnitures(): Call<ArrayList<Furniture>>
}