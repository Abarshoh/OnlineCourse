package uz.akbar.courseshopping

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.akbar.courseshopping.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var edit: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val courses = intent.getSerializableExtra("course") as Course
        binding.name.text = courses.name
        binding.price.text = courses.price.toString()

//        binding.addToCart.setOnClickListener {
//            val intent = Intent(this, Card::class.java)
//            intent.putExtra("course", courses)
//            startActivity(intent)
//        }
        binding.back.setOnClickListener {
            finish()
        }
    }
}