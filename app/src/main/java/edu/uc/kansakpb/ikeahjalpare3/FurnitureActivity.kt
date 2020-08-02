package edu.uc.kansakpb.ikeahjalpare3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_furniture.*
import kotlinx.android.synthetic.main.main_fragment.*

class FurnitureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_furniture)
        intent.getStringExtra("Value")
        var st = intent.getStringExtra("Value") as String
        tvSample2.setText(st)

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }




    }
}