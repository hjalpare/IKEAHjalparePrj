package edu.uc.kansakpb.ikeahjalpare3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.core.view.GestureDetectorCompat
import androidx.fragment.app.Fragment
import edu.uc.kansakpb.ikeahjalpare3.ui.main.MainFragment
import kotlinx.android.synthetic.main.activity_furniture.*

class FurnitureActivity : AppCompatActivity() {
    private lateinit var mainFragment: MainFragment
    private lateinit var activeFragment: Fragment
    private lateinit var detector: GestureDetectorCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_furniture)
            //Extra intent stored the value of the string typed from main
        intent.getStringExtra("Value")
        var inputMain = intent.getStringExtra("Value") as String

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)
        }

            //Extracting Furniture Name from input
        var nameFurn = inputMain.split(" ")[0]
        furnNameTitle.setText(nameFurn)
            //Extracts the URL form the text, stores it into vidLink
        var pullURL = extractUrl(inputMain)
        vidLink.setText(pullURL)
            //Extracting Manual link form input
        var pullManualText = inputMain
        var pullManual = pullManualText.substring(pullManualText.lastIndexOf(" ")+1)

        instructionsMan.setText(pullManual)

        detector = GestureDetectorCompat(this, FurnitureGestureListener())
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return if (detector.onTouchEvent(event)) {
            true
        } else {
            super.onTouchEvent(event)
        }
    }

    inner class FurnitureGestureListener : GestureDetector.SimpleOnGestureListener() {
        private val    SWIPE_THRESHOLD = 100
        private val SWIPE_VELOCITY_THESHOLD = 100
        override fun onFling(
            downEvent: MotionEvent?,
            moveEvent: MotionEvent?,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            var diffX = moveEvent?.x?.minus(downEvent!!.x) ?: 0.0F
            var diffY = moveEvent?.y?.minus(downEvent!!.y) ?: 0.0F

            return if (Math.abs(diffX) > Math.abs(diffY)) {
                //This is left or right swipe
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THESHOLD) {
                    if (diffX > 0) {
                        //right swipe
                        this@FurnitureActivity.onSwipeRight()
                    } else {
                        //left swipe
                        this@FurnitureActivity.onSwipeLeft()
                    }
                    true
                } else {
                    super.onFling(downEvent, moveEvent, velocityX, velocityY)
                }
            } else {
                //Bottom or tops Swipes
                if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THESHOLD) {
                    if (diffY > 0) {
                        this@FurnitureActivity.onSwipeTop()
                    } else {
                        this@FurnitureActivity.onSwipeBottom()
                    }
                    true
                } else {
                    super.onFling(downEvent, moveEvent, velocityX, velocityY)
                }
            }
        }
    }

        //Functions for when swiped
    private fun onSwipeBottom() {
        TODO("Not yet implemented")
    }

    private fun onSwipeTop() {
        TODO("Not yet implemented")
    }

    private fun onSwipeLeft() {
        TODO("Not yet implemented")
    }

    private fun onSwipeRight() {
        if (activeFragment != mainFragment) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.actFurn, mainFragment)
                .commitNow()
            activeFragment = mainFragment
        }
    }

        //Checks if it is a valid URL
    private fun String.isValidUrl(): Boolean = Patterns.WEB_URL.matcher(this).matches()

        //Finds the First URL when split
    private fun extractUrl(input: String) =
        input
        .split(" ")
        .firstOrNull { Patterns.WEB_URL.matcher(it).find()
    }
}