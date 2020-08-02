package edu.uc.kansakpb.ikeahjalpare3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.GestureDetectorCompat
import androidx.fragment.app.Fragment
import edu.uc.kansakpb.ikeahjalpare3.R.layout.main_fragment
import edu.uc.kansakpb.ikeahjalpare3.ui.main.MainFragment
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainFragment: MainFragment
    private lateinit var activeFragment: Fragment
    private lateinit var detector: GestureDetectorCompat

            //Displays Content in main_activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(main_fragment)

            //Search button stores actFurnitureName as Intent Extra
        val btnSearch = findViewById<Button>(R.id.btnSearch)
        btnSearch.setOnClickListener {
            val intent = Intent(this, FurnitureActivity::class.java)
            val inputValue: String = actFurnitureName.text.toString()
            if (inputValue == null || inputValue.trim()==""){
                Toast.makeText(this,"Your Furniture Name Text Field is empty",Toast.LENGTH_LONG).show()
            }else{
                intent.putExtra("Value", inputValue)
                startActivity(intent)
            }
        }

        mainFragment = MainFragment.newInstance()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main, mainFragment)
                .commitNow()
        }
    }


}
