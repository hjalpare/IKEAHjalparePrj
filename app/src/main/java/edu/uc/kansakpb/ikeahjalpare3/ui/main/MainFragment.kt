package edu.uc.kansakpb.ikeahjalpare3.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import edu.uc.kansakpb.ikeahjalpare3.R
import edu.uc.kansakpb.ikeahjalpare3.dto.Furniture
import kotlinx.android.synthetic.main.main_activity.*

open class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

            //Inflate in onCreateView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_activity, container, false)
    }

            //Implemented spinner dropdown
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.furnitures.observe(viewLifecycleOwner, Observer {
                furnitures: ArrayList<Furniture> -> actFurnitureName.setAdapter(ArrayAdapter(context!!, R.layout.support_simple_spinner_dropdown_item, furnitures))
        })
    }
}