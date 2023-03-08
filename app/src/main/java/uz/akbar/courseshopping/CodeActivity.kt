package uz.akbar.courseshopping

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_code.*
import kotlinx.android.synthetic.main.activity_register.*
import uz.akbar.courseshopping.databinding.ActivityCodeBinding

class CodeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityCodeBinding
    private var listPin = mutableListOf<String>()
    private var index = 0
    private lateinit var getPreferences: SharedPreferences
    private lateinit var edit: SharedPreferences.Editor
    private lateinit var getPreferencesState: SharedPreferences
    private lateinit var editState: SharedPreferences.Editor
//    private var pinList = mutableListOf<Pin>()
//    var str: String = ""
//    var clickcount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCodeBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val shared: SharedPreferences = getSharedPreferences("login", MODE_PRIVATE)
//        val edit = shared.edit()
//        val gson = Gson()
//        val convert = object : TypeToken<List<User>>() {}.type
//        val intent = Intent(this, CodeActivity::class.java)
//        one.setOnClickListener(this)
//        two.setOnClickListener(this)
//        three.setOnClickListener(this)
//        four.setOnClickListener(this)
//        five.setOnClickListener(this)
//        six.setOnClickListener(this)
//        seven.setOnClickListener(this)
//        eight.setOnClickListener(this)
//        nine.setOnClickListener(this)
//        zero.setOnClickListener(this)
        val gson = Gson()

        getPreferences = getSharedPreferences("pin_code", MODE_PRIVATE)
        getPreferencesState = getSharedPreferences("state", MODE_PRIVATE)
        edit = getPreferences.edit()
        editState = getPreferencesState.edit()

    loadNumbers()

    binding.next.setOnClickListener {
        val intent = Intent(this, MainActivity::class.java)
        val s = gson.toJson(listPin)
        edit.putString("Users", s).apply()
        editState.putBoolean("State", true).apply()
        startActivity(intent)
    }

    }

    override fun onClick(p0: View?) {
//        var btn = findViewById<TextView>(p0!!.id)
//        btn.isClickable = false
//        str += btn.text
//        btn.setBackgroundResource(R.drawable.btn_bcg_blue)
//        val shared: SharedPreferences = getSharedPreferences("pin", MODE_PRIVATE)
//        val edit = shared.edit()
//        val gson = Gson()
//        val convert = object : TypeToken<List<User>>() {}.type
//        if (clickcount.toString() == "1") {
//            cuberepressed(cube1, btn)
//        }
//        if (clickcount.toString() == "2") {
//            cuberepressed(cube2, btn)
//        }
//        if (clickcount.toString() == "3") {
//            cuberepressed(cube3, btn)
//        }
//        if (clickcount.toString() == "4") {
//            cuberepressed(cube4, btn)
//        }
//
//        next.setOnClickListener {
//            var pins =shared.getString("pins","")
//            if (pins == ""){
//                pinList = mutableListOf()
//            }else{
//                pinList = gson.fromJson(pins,convert)
//            }
//
//            if (validate()){
//                pinList.add(Pin(cube1.text.toString(), cube2.text.toString(),cube3.text.toString(),cube4.text.toString()))
//                val string = gson.toJson(pinList)
//                edit.putString("pins", string).apply()
//                Toast.makeText(this,"Successfully registered", Toast.LENGTH_SHORT).show()
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//            }
//        }

        if (listPin.size < 4) {
            listPin.add(p0!!.tag.toString())
            index++
            when (index) {
                1 -> binding.pin1.setBackgroundResource(R.drawable.pin_code_oval_checked)
                2 -> binding.pin2.setBackgroundResource(R.drawable.pin_code_oval_checked)
                3 -> binding.pin3.setBackgroundResource(R.drawable.pin_code_oval_checked)
                4 -> binding.pin4.setBackgroundResource(R.drawable.pin_code_oval_checked)
            }
        }
        if (listPin.size == 4) {
            binding.next.visibility = View.VISIBLE
        }
    }
//    fun cuberepressed(cube: TextView, btn: TextView) {
//        cube.text = btn.text
//        cube.setTextColor(Color.BLACK)
//        cube.setBackgroundResource(R.drawable.cube_bcg_pressed)
//    }

//    private fun validate(): Boolean {
//        for (i in pinList.indices) {
//            if (cube1.text.toString() == pinList[i].cube1 && cube2.text.toString() == pinList[i].cube2
//                && cube3.text.toString() == pinList[i].cube3 && cube4.text.toString() == pinList[i].cube4) {
//                Toast.makeText(this, "User with this username already registered", Toast.LENGTH_SHORT).show()
//                return false
//            }
//        }
//        return true
//    }

    private fun loadNumbers() {
        binding.one.setOnClickListener(this)
        binding.two.setOnClickListener(this)
        binding.three.setOnClickListener(this)
        binding.four.setOnClickListener(this)
        binding.five.setOnClickListener(this)
        binding.six.setOnClickListener(this)
        binding.seven.setOnClickListener(this)
        binding.eight.setOnClickListener(this)
        binding.nine.setOnClickListener(this)
        binding.zero.setOnClickListener(this)
    }
}