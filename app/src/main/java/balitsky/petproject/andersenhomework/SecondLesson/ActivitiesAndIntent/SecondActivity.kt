package balitsky.petproject.andersenhomework.SecondLesson.ActivitiesAndIntent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import balitsky.petproject.andersenhomework.R

class SecondActivity : AppCompatActivity() {
    val EXTRA_MESSAGE_SECOND = "MESSAGE_FROM_SECOND_ACTIVITY"
    val EXTRA_MESSAGE_FIRST = "MESSAGE_FROM_FIRST_ACTIVITY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent = intent;
        val replyMsg = findViewById<TextView>(R.id.received_msg)
        replyMsg.setText(intent.getStringExtra(EXTRA_MESSAGE_FIRST))
    }

    fun onSendReply(view: View)
    {
        val editText = findViewById<EditText>(R.id.replyMessage)
        val message = editText.text.toString()
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE_SECOND, message)
        }
        setResult(RESULT_OK, intent)
        finish()
    }
}