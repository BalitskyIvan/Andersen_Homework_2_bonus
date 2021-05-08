package balitsky.petproject.andersenhomework.Bonus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import balitsky.petproject.andersenhomework.R

class StatisticActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistic)
        val count = findViewById<TextView>(R.id.statistic_text)
        count.text = intent.getStringExtra("COUNT")
    }

    fun statistikOk(view: View)
    {
        finish()
    }
}