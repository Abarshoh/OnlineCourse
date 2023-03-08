package uz.akbar.courseshopping

import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import uz.akbar.courseshopping.databinding.ActivitySplashBinding
import java.util.*

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private lateinit var getSharedPreferences: SharedPreferences
    private lateinit var getSharedPreferences2: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSharedPreferences = getSharedPreferences("state", MODE_PRIVATE)
        val state = getSharedPreferences.getBoolean("State", false)
        getSharedPreferences2 = getSharedPreferences("lang", MODE_PRIVATE)
        val lang = getSharedPreferences2.getString("lang", "En")

        var languageToLoad: String? = null

        if (lang == "En") {
            languageToLoad = "en"
        }  else if (lang == "Uz") {
            languageToLoad = "uz"
        }

        if (languageToLoad != null) {
            val locale = Locale(languageToLoad)
            Locale.setDefault(locale)
            val config = Configuration()
            config.locale = locale
            baseContext.resources.updateConfiguration(
                config,
                baseContext.resources.displayMetrics
            )
        }

        Handler(Looper.getMainLooper()).postDelayed({
            if (!state) {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, EnterPinActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 3000)
    }
}