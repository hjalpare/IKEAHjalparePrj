package edu.uc.kansakpb.ikeahjalpare3.dao

import android.telecom.Call
import edu.uc.kansakpb.ikeahjalpare3.dto.Furniture
import retrofit2.http.GET

interface IFurnitureDAO {
    //Created DAO class for
    // json file to search IKEA: http://www.ikea.com/us/en/iows/catalog/availability/12345678 replace: https://api.npoint.io
    @GET("/us/en/iows/catalog/availability/12345678")
    fun getAllFurnitures(): retrofit2.Call<ArrayList<Furniture>>

    @GET("/us/en/iows/catalog/availability/12345678")
    fun getFurnitures(furnitureName: String) : retrofit2.Call<ArrayList<Furniture>>
}