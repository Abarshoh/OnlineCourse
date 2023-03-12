package uz.akbar.courseshopping

import android.R
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.*
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_terms.*
import uz.akbar.courseshopping.databinding.ActivityTermsBinding
import java.util.*
import kotlin.system.exitProcess
import android.widget.AdapterView.OnItemSelectedListener as OnItemSelectedListener1

class TermsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTermsBinding
    lateinit var locale: Locale
    private var currentLang: String? = null
    private var currentLanguage = "en"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTermsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        currentLanguage = intent.getStringExtra(currentLang).toString()
        val list = ArrayList<String>()
        list.add("Select Language")
        list.add("English")
        list.add("Uzbek")

        val adapter = ArrayAdapter(
            this,           androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,            list
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object : OnItemSelectedListener1 {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                when (position) {
                    0 -> {
                    }
                    1 -> setLocale("en")
                    2 -> setLocale("uz")
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        binding.checkBox.setOnCheckedChangeListener { compoundButton, b ->
            binding.nextBtn.isEnabled = true
        }
        binding.nextBtn.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
    private fun setLocale(localeName: String) {
        if (localeName != currentLanguage) {
            locale = Locale(localeName)
            val res = resources
            val dm = res.displayMetrics
            val conf = res.configuration
            conf.locale = locale
            res.updateConfiguration(conf, dm)
            val refresh = Intent(
                this,
                TermsActivity::class.java
            )
            refresh.putExtra(currentLang, localeName)
            startActivity(refresh)
        } else {
            Toast.makeText(
                this, "Language, , already, , selected)!", Toast.LENGTH_SHORT).show();
        }
    }
    override fun onBackPressed() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
        exitProcess(0)
    }

}