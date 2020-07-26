package edu.uc.kansakpb.ikeahjalpare3.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import edu.uc.kansakpb.ikeahjalpare3.FurnitureActivity
import edu.uc.kansakpb.ikeahjalpare3.R
import edu.uc.kansakpb.ikeahjalpare3.dto.Furniture
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
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.furnitures.observe(viewLifecycleOwner, Observer {

                _furnitures -> actFurnitureName.setAdapter(ArrayAdapter(context!!, R.layout.support_simple_spinner_dropdown_item, _furnitures))

        })

        actFurnitureName.onItemSelectedListener =  object : AdapterView.OnItemSelectedListener {
            /**
             * Callback method to be invoked when the selection disappears from this
             * view. The selection can disappear for instance when touch is activated
             * or when the adapter becomes empty.
             *
             * @param parent The AdapterView that now contains no selected item.
             */
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            /**
             * @param parent The AdapterView where the selection happened
             * @param view The view within the AdapterView that was clicked
             * @param position The position of the view in the adapter
             * @param id The row id of the item that is selected
             */


            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                /** TODO: Get the selected item as a Furniture object */
            }


        }
     
        btnSelect.setOnClickListener{
            /** TODO: check the text of actFurniture to see if it is filled or not
             *
             * if not empty, load the video in to the VideoView
             */
        }


    }

    private fun populateUI() {
        /** TODO: set the listener for the Instruction Manual button to open the pdf in a new activity
         *
         * set the URL of the VideoView.
         */
    }

}