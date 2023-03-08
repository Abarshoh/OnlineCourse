package uz.akbar.courseshopping

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.akbar.courseshopping.databinding.ActivityMainBinding
import uz.akbar.courseshopping.databinding.CourseItemBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var listComment = mutableListOf<String>()
    private var listRec = mutableListOf<Course>()
    private val type = "type"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val type1 = object : TypeToken<List<String>>() {}.type
        val gson = Gson()

        var adapter = CourseAdapter(this,listRec)
        binding.main.adapter = adapter

        loadRec()


        binding.main.setOnItemClickListener { _, _, i, _ ->
            val course = listRec.get(i)
            val intent = Intent(this, InfoActivity::class.java)
            intent.putStringArrayListExtra("course", course)
            startActivity(intent)
        }
        binding.search.addTextChangedListener {
            val filter = mutableListOf<Course>()
            if (it != null){
                var fav = listRec
                for (c in fav){
                    if (c.name.lowercase().contains(it.toString().lowercase())){
                        filter.add(c)
                    }
                }
                adapter = CourseAdapter(this,filter)
                binding.main.adapter = adapter
            }
        }
    }

    private fun loadRec(){
        listRec.add(Course("UI design",R.drawable.course1,150))
        listRec.add(Course("Mobile development",R.drawable.course1,250))
        listRec.add(Course("Photography class",R.drawable.course1,100))
        listRec.add(Course("Math class",R.drawable.course1,150))
        listRec.add(Course("Philosophy class",R.drawable.course1,300))
        listRec.add(Course("Physics class",R.drawable.course1,200))
        listRec.add(Course("English class",R.drawable.course1,150))
        listRec.add(Course("Psychology class",R.drawable.course1,150))
        listRec.add(Course("Web development",R.drawable.course1,150))
        listRec.add(Course("UI design",R.drawable.course1,150))
    }
}

private fun Intent.putStringArrayListExtra(s: String, course: Course) {

}
