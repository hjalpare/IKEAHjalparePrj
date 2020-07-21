package edu.uc.kansakpb.ikeahjalpare3.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.uc.kansakpb.ikeahjalpare3.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.furnitures.observe(this, Observer{
            furnitures -> actFurnitureName.setAdapter(ArrayAdapter(context))
        })
        // TODO: Use the ViewModel
    }

    private fun saveModel(){
        var model = Model().apply {
            description = txtDescription.text.toString()
            furnitureName = actFurnitureName.text.toString()
        }

        viewModel.save(model)
    }

}