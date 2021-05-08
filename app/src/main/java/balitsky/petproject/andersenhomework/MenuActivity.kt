package balitsky.petproject.andersenhomework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import balitsky.petproject.andersenhomework.Bonus.VoronCounterActivity
import balitsky.petproject.andersenhomework.FirstLesson.*
import balitsky.petproject.andersenhomework.SecondLesson.ActivitiesAndIntent.FirstActivity
import balitsky.petproject.andersenhomework.SecondLesson.ImplicitIntents.ImplicitIntentsActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    fun openPartA(view: View) {
        val intent = Intent(this, PartAActivity::class.java)
        startActivity(intent)
    }

    fun openPartB(view: View) {
        val intent = Intent(this, PartBActivity::class.java)
        startActivity(intent)
    }

    fun openPartBLinear(view: View) {
        val intent = Intent(this, PartBActivityLinear::class.java)
        startActivity(intent)
    }

    fun openPartBRelative(view: View) {
        val intent = Intent(this, PartBActivityRelative::class.java)
        startActivity(intent)
    }

    fun openScrollView(view: View) {
        val intent = Intent(this, ScrollingViews::class.java)
        startActivity(intent)
    }

    fun openActivitiesAndIntents(view: View) {
        val intent = Intent(this, FirstActivity::class.java)
        startActivity(intent)
    }

    fun openImplicitIntents(view: View) {
        val intent = Intent(this, ImplicitIntentsActivity::class.java)
        startActivity(intent)
    }

    fun openVoronCounter(view: View)
    {
        val intent = Intent(this, VoronCounterActivity::class.java)
        startActivity(intent)
    }
}