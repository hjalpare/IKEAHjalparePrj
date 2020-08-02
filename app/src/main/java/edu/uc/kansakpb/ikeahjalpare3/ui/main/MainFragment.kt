package edu.uc.kansakpb.ikeahjalpare3.ui.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import edu.uc.kansakpb.ikeahjalpare3.R
import edu.uc.kansakpb.ikeahjalpare3.dto.Furniture
import kotlinx.android.synthetic.main.activity_furniture.*
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.android.synthetic.main.main_fragment.*

open class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_activity, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.furnitures.observe(viewLifecycleOwner, Observer {
                furnitures: ArrayList<Furniture> -> actFurnitureName.setAdapter(ArrayAdapter(context!!, R.layout.support_simple_spinner_dropdown_item, furnitures))
        })

//        editTextSample.addTextChangedListener(object : TextWatcher {
//
//            override fun afterTextChanged(s: Editable) {}
//
//            override fun beforeTextChanged(s: CharSequence, start: Int,
//                                           count: Int, after: Int) {
//            }
//
//            override fun onTextChanged(s: CharSequence, start: Int,
//                                       before: Int, count: Int) {
//                //tvSample.setText("Text in EditText : "+s)
//            }
//        })
    }
}