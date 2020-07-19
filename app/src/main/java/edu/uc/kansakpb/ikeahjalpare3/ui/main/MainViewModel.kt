package edu.uc.kansakpb.ikeahjalpare3.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.uc.kansakpb.ikeahjalpare3.dto.Furniture
import edu.uc.kansakpb.ikeahjalpare3.service.FurnitureService

class MainViewModel : ViewModel() {
    var furnitures: MutableLiveData<ArrayList<Furniture>> = MutableLiveData<ArrayList<Furniture>>()
    var furnitureService: FurnitureService = FurnitureService()

    internal fun fetchFurnitures(furnitureName: String) {
        furnitures = furnitureService.fetchFurnitures(furnitureName)
    }
    // TODO: Implement the ViewModel
}