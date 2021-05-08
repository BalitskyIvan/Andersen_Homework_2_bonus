package balitsky.petproject.andersenhomework.SecondLesson.ActivitiesAndIntent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible
import balitsky.petproject.andersenhomework.R

class FirstActivity : AppCompatActivity() {
    private val LOG_TAG = "FirstActivity"
    val EXTRA_MESSAGE_SECOND = "MESSAGE_FROM_SECOND_ACTIVITY"
    val EXTRA_MESSAGE_FIRST = "MESSAGE_FROM_FIRST_ACTIVITY"
    val REPLY_VISIBLE = "REPLY_VISIBLE"
    val REPLY_TEXT = "REPLY_TEXT"
    val SUCCESS_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean(REPLY_VISIBLE)) {
                val reply = findViewById<TextView>(R.id.text_message_reply)
                val replyHeader = findViewById<TextView>(R.id.text_header_reply)
                replyHeader.visibility = View.VISIBLE
                reply.visibility = View.VISIBLE
                reply.setText(savedInstanceState.getString(REPLY_TEXT))
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val reply = findViewById<TextView>(R.id.text_message_reply)
        if (reply.visibility == View.VISIBLE) {
            outState.putBoolean(REPLY_VISIBLE, true)
            outState.putString(REPLY_TEXT, reply.text.toString())
        }
    }

    fun onSendMessage(view: View) {
        Log.d(LOG_TAG, "Button clicked!")
        val editText = findViewById<EditText>(R.id.editText)
        val message = editText.text.toString()
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE_FIRST, message)
        }
        startActivityForResult(intent, SUCCESS_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SUCCESS_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                val reply = findViewById<TextView>(R.id.text_message_reply)
                val replyHeader = findViewById<TextView>(R.id.text_header_reply)
                replyHeader.visibility = View.VISIBLE
                reply.visibility = View.VISIBLE
                if (data != null) {
                    reply.setText(data.getStringExtra(EXTRA_MESSAGE_SECOND))
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "On start")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "On pause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "On restart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "On resume")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "On stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "On destroy")
    }
}