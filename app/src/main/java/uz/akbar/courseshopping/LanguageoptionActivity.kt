package uz.akbar.courseshopping

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class LanguageoptionActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val languageSpinner = findViewById<Spinner>(R.id.spinner)
        val languages = resources.getStringArray(R.array.languages)

//        languageSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, languages)
//
//        languageSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
//                val language = when (position) {
//                    0 -> "en"
//                    1 -> "es"
//                    else -> "en"
//                }
//                LocaleHelper.setLocale(this@LanguageoptionActivity, language)
//                recreate()
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>) {}
//        }
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}