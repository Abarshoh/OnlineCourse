package uz.akbar.courseshopping

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import uz.akbar.courseshopping.databinding.CourseItemBinding

class CourseAdapter(context: Context, var courses: MutableList<Course>):ArrayAdapter<Course>(context,R.layout.course_item,courses) {
    override fun getCount(): Int {
        return courses.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var binding: CourseItemBinding
        if (convertView == null) {
            binding = CourseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        } else {
            binding = CourseItemBinding.bind(convertView)
        }
        val course = courses.get(position)
//        binding.img.load(course.img) {
//            placeholder(R.drawable.ic_launcher_background)
//            error(androidx.appcompat.R.drawable.abc_btn_radio_material_anim)
//        }
        binding.img.setImageResource(course.img)

        binding.name.text = course.name
        binding.price.text = course.price.toString()
        return binding.root
    }


}
