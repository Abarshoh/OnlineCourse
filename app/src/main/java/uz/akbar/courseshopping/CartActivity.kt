package uz.akbar.courseshopping

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.akbar.courseshopping.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {
    lateinit var binding: ActivityCartBinding
    private var listOrder = mutableListOf<Course>()
    private var oldList = mutableListOf<Course>()
    private var total = 0
    private lateinit var getPreferences: SharedPreferences
    private lateinit var edit: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val type = object : TypeToken<List<Course>>() {}.type
        val gson = Gson()

        getPreferences = getSharedPreferences("ordered", MODE_PRIVATE)
        edit = getPreferences.edit()

        val str = getPreferences.getString("order", "")

        if (str == "") {
            listOrder = mutableListOf()
        } else {
            listOrder = gson.fromJson(str, type)
        }

        if (intent.getSerializableExtra("course") != null &&
            !listOrder.contains(intent.getSerializableExtra("course"))) {
            val foods = intent.getSerializableExtra("course") as Course
            oldList.add(foods)
        }
        listOrder.addAll(oldList)

        var adapter = CourseAdapter(this, listOrder)
        binding.main.adapter = adapter

        for (i in listOrder) {
            total += i.price
        }
        binding.total.text = total.toString()



        binding.clear.setOnClickListener {
            listOrder.clear()
            total = 0
            binding.total.text = total.toString()
            adapter = CourseAdapter(this, listOrder)
            binding.main.adapter = adapter
            val s = gson.toJson(listOrder)
            edit.putString("order", s).apply()


        }
        val s = gson.toJson(listOrder)
        edit.putString("order", s).apply()

        binding.back.setOnClickListener {
            finish()
        }
    }

}