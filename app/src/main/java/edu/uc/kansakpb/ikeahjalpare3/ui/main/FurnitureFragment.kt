package edu.uc.kansakpb.ikeahjalpare3.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import edu.uc.kansakpb.ikeahjalpare3.R

//FurnitureFragment does nothing for the time being

//Kept here bc I might use this code later

class FurnitureFragment : MainFragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.activity_furniture, container, false)

    }

//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View {
//        return inflater.inflate(R.layout.main_fragment, container, false)
//    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        activity.let {
//            viewModel = ViewModelProviders.of(it!!).get(MainViewModel::class.java)
//        }
//        btnSaveEvent.setOnClickListener {
//            saveEvent()
//        }
//        btnTakeEventPhoto.setOnClickListener {
//            prepTakePhoto()
//        }
//        btnBackToSpecimen.setOnClickListener {
//            (activity as MainActivity).onSwipeRight()
//        }
}