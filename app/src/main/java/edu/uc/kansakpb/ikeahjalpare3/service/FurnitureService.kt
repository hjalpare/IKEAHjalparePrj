package edu.uc.kansakpb.ikeahjalpare3.service

import androidx.lifecycle.MutableLiveData
import edu.uc.kansakpb.ikeahjalpare3.RetrofitClientInstance
import edu.uc.kansakpb.ikeahjalpare3.dao.IFurnitureDAO
import edu.uc.kansakpb.ikeahjalpare3.dto.Furniture
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FurnitureService {

    internal fun fetchFurnitures(furnitureName: String) : MutableLiveData<ArrayList<Furniture>> {
        //MVD is defined
        val furnitures = MutableLiveData<ArrayList<Furniture>>()
        val service = RetrofitClientInstance.retrofitInstance?.create(IFurnitureDAO::class.java)
        val call = service?.getAllFurnitures()
        call?.enqueue(object: Callback<ArrayList<Furniture>> {
            //Call onResponse to determine if the response indicates success.
            override fun onResponse(
                call: Call<ArrayList<Furniture>>,
                response: Response<ArrayList<Furniture>>
            ) {
                furnitures.value = response.body()
            }
            //Call onFailure to determine if the response indicates success.
            override fun onFailure(call: Call<ArrayList<Furniture>>, t: Throwable) {
                throw Exception("Unable to parse json file")
            }
        })
        return furnitures
    }
}