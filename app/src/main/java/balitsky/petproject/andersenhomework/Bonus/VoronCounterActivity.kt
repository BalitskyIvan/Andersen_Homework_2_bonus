package balitsky.petproject.andersenhomework.Bonus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.TextureView
import android.view.View
import android.widget.EditText
import android.widget.TextView
import balitsky.petproject.andersenhomework.R
import balitsky.petproject.andersenhomework.SecondLesson.ActivitiesAndIntent.SecondActivity

class VoronCounterActivity : AppCompatActivity() {

    var voronCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voron_counter)
        if (savedInstanceState != null && savedInstanceState.getBoolean("is_saved")) {
            voronCount = savedInstanceState.getInt("count")
            val textView = findViewById<TextView>(R.id.voronText)
            textView.text = voronCount.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val count = findViewById<TextView>(R.id.voronText)
        outState.putBoolean("is_saved", true)
        outState.putInt("count", voronCount)
    }

    fun countVoron(view: View) {
        voronCount++
        val textView = findViewById<TextView>(R.id.voronText)
        textView.text = voronCount.toString()
    }


    fun openStatistic(view: View) {
        val count = findViewById<TextView>(R.id.voronText)
        val message = count.text.toString()
        val intent = Intent(this, StatisticActivity::class.java).apply {
            putExtra("COUNT", message)
        }
        startActivity(intent)
    }
}