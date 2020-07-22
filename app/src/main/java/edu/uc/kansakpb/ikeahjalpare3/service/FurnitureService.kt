package edu.uc.kansakpb.ikeahjalpare3.service

import androidx.lifecycle.MutableLiveData
import edu.uc.kansakpb.ikeahjalpare3.ui.main.RetrofitClientInstance
import edu.uc.kansakpb.ikeahjalpare3.dao.IFurnitureDAO
import edu.uc.kansakpb.ikeahjalpare3.dto.Furniture
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FurnitureService {

    internal fun fetchFurnitures(furnitureName: String) : MutableLiveData<ArrayList<Furniture>> {
        var _furnitures = MutableLiveData<ArrayList<Furniture>>()
        val service = RetrofitClientInstance.retrofitInstance?.create(IFurnitureDAO::class.java)
        val call = service?.getAllFurnitures()
        call?.enqueue(object: Callback<ArrayList<Furniture>> {
            override fun onResponse(
                call: Call<ArrayList<Furniture>>,
                response: Response<ArrayList<Furniture>>
            ) {
                _furnitures.value = response.body()
            }
            override fun onFailure(call: Call<ArrayList<Furniture>>, t: Throwable) {
                val j = 1 + 1
                val i = 1 + 1
            }
        })
        return _furnitures
    }
}