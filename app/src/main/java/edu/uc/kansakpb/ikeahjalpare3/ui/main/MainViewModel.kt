package edu.uc.kansakpb.ikeahjalpare3.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.uc.kansakpb.ikeahjalpare3.dto.Furniture
import edu.uc.kansakpb.ikeahjalpare3.service.FurnitureService

class MainViewModel : ViewModel() {
    var _furnitures: MutableLiveData<ArrayList<Furniture>> = MutableLiveData<ArrayList<Furniture>>()
    var furnitureService: FurnitureService = FurnitureService()

    init {
        fetchFurnitures("furnitureName")
    }

    internal fun fetchFurnitures(furnitureName: String) {
        _furnitures = furnitureService.fetchFurnitures(furnitureName)
    }

    internal var furnitures: MutableLiveData<ArrayList<Furniture>>
        get() {return _furnitures}
        set(value) {_furnitures = value}
}