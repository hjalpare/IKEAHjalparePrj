package edu.uc.kansakpb.ikeahjalpare3.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.uc.kansakpb.ikeahjalpare3.dto.Furniture
import edu.uc.kansakpb.ikeahjalpare3.dto.Model
import edu.uc.kansakpb.ikeahjalpare3.service.FurnitureService

class MainViewModel : ViewModel() {
    private var _furnitures: MutableLiveData<ArrayList<Furniture>> = MutableLiveData<ArrayList<Furniture>>()
    var furnitureService: FurnitureService = FurnitureService()
    private lateinit var firestore : FirebaseFireStore

    init {
        fetchFurnitures("e")
        firestore = FirebaseFirestore.getInstance()
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }

    fun fetchFurnitures(furnitureName: String) {
        _furnitures = furnitureService.fetchFurnitures(furnitureName)
    }

    fun save(model: Model) {
        firestore.collection("models")
            .document()
            .set(model)
            .addOnSuccessListener {
                Log.d("Firebase", "Document Saved")
            }
            .addOnFailureListener {
                Log.d("Firebase", "Save Failed")
            }
    }

    internal var furniture:MutableLiveData<ArrayList<Furniture>>
        get() {return _furnitures}
        set(value) {_furnitures = value}
}