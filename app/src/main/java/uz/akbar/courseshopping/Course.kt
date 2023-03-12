package uz.akbar.courseshopping

data class Course(var name:String, var img:Int, var price:Int,var isAddedToCart: Boolean,
                  var count: Int = 1,var subTotal:Int):java.io.Serializable {
}