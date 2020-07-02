package edu.uc.kansakpb.ikeahjalpare3.dao

import android.telecom.Call
import edu.uc.kansakpb.ikeahjalpare3.dto.Furniture
import retrofit2.http.GET

interface IFurnitureDAO {
    //Created DAO class for
    @GET("/dbc64a5b111a92183e33.json")
    fun getAllFurnitures(): retrofit2.Call<ArrayList<Furniture>>

    @GET("/dbc64a5b111a92183e33.json")
    fun getFurnitures(furnitureName: String) : retrofit2.Call<ArrayList<Furniture>>
}