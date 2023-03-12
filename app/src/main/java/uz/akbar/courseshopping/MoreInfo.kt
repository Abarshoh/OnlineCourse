package uz.akbar.courseshopping

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.akbar.courseshopping.databinding.ActivityMoreInfoBinding

class MoreInfo : AppCompatActivity() {
    private lateinit var binding: ActivityMoreInfoBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var edit: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoreInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val courses = intent.getSerializableExtra("course") as Course
        binding.img.setImageResource(courses.img)
        binding.name.text = courses.name
        binding.price.text = courses.price.toString()

        binding.addToCart.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            intent.putExtra("course", courses)
            startActivity(intent)
        }
        binding.back.setOnClickListener {
            finish()
        }
    }
}

