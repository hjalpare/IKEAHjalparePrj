package edu.uc.kansakpb.ikeahjalpare3.dao

import edu.uc.kansakpb.ikeahjalpare3.dto.Furniture
import retrofit2.http.GET
import retrofit2.Call

interface IFurnitureDAO {
    //Created DAO class for
    @GET("/dbc64a5b111a92183e33.json")
    fun getAllFurnitures(): Call<ArrayList<Furniture>>

    @GET("/dbc64a5b111a92183e33.json")
    fun getFurnitures(furnitureName: String) : Call<ArrayList<Furniture>>
}