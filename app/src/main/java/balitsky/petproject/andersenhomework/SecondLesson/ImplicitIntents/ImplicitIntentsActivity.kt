package balitsky.petproject.andersenhomework.SecondLesson.ImplicitIntents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import balitsky.petproject.andersenhomework.R


class ImplicitIntentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intents)
    }

    fun openWebsite(view: View) {
        val editWebsite = findViewById<EditText>(R.id.website_edittext)
        val webpage: Uri = Uri.parse(editWebsite.text.toString())
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }

    fun openLocation(view: View) {
        val editLocation = findViewById<EditText>(R.id.location_edittext)
        val addressUri = Uri.parse("geo:0,0?q=" + editLocation.text.toString())
        val intent = Intent(Intent.ACTION_VIEW, addressUri)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }

    fun shareText(view: View) {
        val editShare = findViewById<EditText>(R.id.share_edittext)
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
            .setChooserTitle(R.string.share_text_with)
            .setText(editShare.text.toString())
            .startChooser()
    }
}