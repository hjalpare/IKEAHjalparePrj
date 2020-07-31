package edu.uc.kansakpb.ikeahjalpare3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import edu.uc.kansakpb.ikeahjalpare3.R.id.actFurnitureName
import edu.uc.kansakpb.ikeahjalpare3.R.id.main
import edu.uc.kansakpb.ikeahjalpare3.R.layout.main_fragment
import edu.uc.kansakpb.ikeahjalpare3.ui.main.FurnitureFragment
import edu.uc.kansakpb.ikeahjalpare3.ui.main.MainFragment
import kotlinx.android.synthetic.main.activity_furniture.*
import kotlinx.android.synthetic.main.main_fragment.*
import java.net.URLClassLoader.newInstance

class MainActivity : AppCompatActivity() {

    private lateinit var mainFragment: MainFragment
    private lateinit var activeFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(main_fragment)

        val btnSearch = findViewById<Button>(R.id.btnSearch)
        btnSearch.setOnClickListener {
            val furnitureSearchTextViewText: String
            furnitureSearchTextViewText = actFurnitureName.text.toString()
            val intent = Intent(this, FurnitureActivity::class.java)
            startActivity(intent)
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