package balitsky.petproject.andersenhomework.FirstLesson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import balitsky.petproject.andersenhomework.R

class PartBActivityLinear : AppCompatActivity() {
    private var count = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part_blinear)
    }

    fun showToast(view : View)
    {
        Toast.makeText(this, R.string.toast_msg, Toast.LENGTH_SHORT).show()
    }

    fun countUp(view: View)
    {
        val textView: TextView = findViewById(R.id.show_count)
        count++;
        textView.text = count.toString();
    }
}