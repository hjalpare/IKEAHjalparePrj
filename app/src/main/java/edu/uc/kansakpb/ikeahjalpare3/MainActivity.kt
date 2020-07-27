package edu.uc.kansakpb.ikeahjalpare3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import edu.uc.kansakpb.ikeahjalpare3.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
        //searchButton()
    }
//    private fun searchButton() {
//        val btnSearch = findViewById<ImageButton>(R.id.btnSearch)
//        btnSearch.setOnClickListener {
//            val searchIntent = Intent(this, FurnitureActivity::class.java)
//            startActivity(searchIntent)
//        }
//    }
}