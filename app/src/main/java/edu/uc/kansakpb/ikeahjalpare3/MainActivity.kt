package edu.uc.kansakpb.ikeahjalpare3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import edu.uc.kansakpb.ikeahjalpare3.R.id.main
import edu.uc.kansakpb.ikeahjalpare3.R.layout.main_fragment
import edu.uc.kansakpb.ikeahjalpare3.dto.Furniture
import edu.uc.kansakpb.ikeahjalpare3.ui.main.FurnitureFragment
import edu.uc.kansakpb.ikeahjalpare3.ui.main.MainFragment
import edu.uc.kansakpb.ikeahjalpare3.ui.main.MainViewModel
import kotlinx.android.synthetic.main.activity_furniture.*
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.android.synthetic.main.main_fragment.*
import java.net.URLClassLoader.newInstance

class MainActivity : AppCompatActivity() {

    private lateinit var mainFragment: MainFragment
    private lateinit var activeFragment: Fragment

    var view = ""
    //val actFurn: AutoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.actFurnitureName)
        //Displays Content in main_activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(main_fragment)



            //Search button stores actFurnitureName as Intent Extra
        val btnSearch = findViewById<Button>(R.id.btnSearch)
        btnSearch.setOnClickListener {
            val intent = Intent(this, FurnitureActivity::class.java)

//            view = tvSample.text as String
            //var view1 = actFurn.getText()
            val inputValue: String = actFurnitureName.text.toString()
            if (inputValue == null){
                Toast.makeText(this,"please input data, edit text cannot be blank",Toast.LENGTH_LONG).show()
            }else{
//                tvSample.setText(inputValue).toString()
                intent.putExtra("Value", inputValue)
                Toast.makeText(this, "Hi there! This is a Toast: $inputValue", Toast.LENGTH_LONG).show()
                startActivity(intent)
            }

        }


        mainFragment = MainFragment.newInstance()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main, MainFragment.newInstance())
                .commitNow()
            activeFragment = mainFragment
        }

    }
}
