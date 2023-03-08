package uz.akbar.courseshopping

import android.R
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import uz.akbar.courseshopping.databinding.ActivityTermsBinding

class TermsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTermsBinding
    private var list = arrayListOf<String>()
    private lateinit var getPreferences: SharedPreferences
    private lateinit var edit: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTermsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getPreferences = getSharedPreferences("lang", MODE_PRIVATE)
        edit = getPreferences.edit()

        list.add("En")
        list.add("Uz")

        binding.checkBox.setOnCheckedChangeListener { compoundButton, b ->
            binding.nextBtn.isEnabled = true
        }
        binding.nextBtn.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        val adapter = ArrayAdapter<String>(this, R.layout.simple_spinner_item, list)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

    }
}