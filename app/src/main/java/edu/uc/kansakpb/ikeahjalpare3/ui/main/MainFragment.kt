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
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : Fragment() {
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.furnitures.observe(viewLifecycleOwner, Observer {
                _furnitures: ArrayList<Furniture> -> actFurnitureName.setAdapter(ArrayAdapter(context!!, R.layout.support_simple_spinner_dropdown_item, _furnitures))
        })
    }
    companion object {
        fun newInstance() = MainFragment()
    }

}