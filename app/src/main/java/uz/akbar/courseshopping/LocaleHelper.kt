package uz.akbar.courseshopping

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import java.util.*

object LocaleHelper {
    fun setLocale(context: Context, language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)

        val resources = context.resources
        val config = Configuration(resources.configuration)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(locale)
        } else {
            config.locale = locale
        }

        resources.updateConfiguration(config, resources.displayMetrics)
    }
}