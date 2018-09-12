package dev.cherran.restaurapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import dev.cherran.restaurapp.R
import dev.cherran.restaurapp.model.Allergens
import dev.cherran.restaurapp.model.Dish


class DishListAdapter (private val dishList: List<Dish>, private val cellFormat: CellFormat, private val onDishSelectedListener: OnDishSelectedListener?) : RecyclerView.Adapter<DishListAdapter.DishViewHolder>(){
    override fun getItemCount(): Int = dishList.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content_dish, parent, false)
        return DishViewHolder(view, cellFormat)
    }

    override fun onBindViewHolder(viewHolder: DishViewHolder, position: Int) {
        viewHolder.bindDish(dishList[position])

        // onCLick Listener
        viewHolder.itemView.setOnClickListener {
            onDishSelectedListener?.onCourseSelected(dishList[position])
        }
    }


    // View holder
    inner class DishViewHolder(itemView: View, cellFormat: CellFormat) : RecyclerView.ViewHolder(itemView) {

        private val name = itemView.findViewById<TextView>(R.id.dish_name)
        private val price = itemView.findViewById<TextView>(R.id.dish_price)
        private val image = itemView.findViewById<ImageView>(R.id.dish_image)
        private val milkIcon = itemView.findViewById<ImageView>(R.id.milk_icon)
        private val wheatIcon = itemView.findViewById<ImageView>(R.id.wheat_icon)
        private val peanutIcon = itemView.findViewById<ImageView>(R.id.peanut_icon)
        private val crustaceansIcon = itemView.findViewById<ImageView>(R.id.crustaceans_icon)


        fun bindDish(dish: Dish) {
            name.text = dish.name
            price.text = String.format(itemView.context.getString(R.string.price_tag), dish.price)

            if (cellFormat == CellFormat.COMPLETE) { // show dish image in this case
                image.setImageResource(dish.image)
            } else {
                image.visibility = View.GONE
            }

            // Set allergen icons
            if (dish.allergens != null) {
                if (!dish.allergens.contains(Allergens.LACTEOS)) { // Does not have this allergen
                    milkIcon.visibility = View.GONE
                }
                if (!dish.allergens.contains(Allergens.FRUTOS_SECOS)) {
                    peanutIcon.visibility = View.GONE
                }
                if (!dish.allergens.contains(Allergens.MARISCO)) {
                    crustaceansIcon.visibility = View.GONE
                }
                if (!dish.allergens.contains(Allergens.GLUTEN)) {
                    wheatIcon.visibility = View.GONE
                }
            }
        }
    }

}





// onClick listener for dish cells
interface OnDishSelectedListener {
    fun onCourseSelected(dish: Dish?)
}



enum class CellFormat {
    COMPLETE, SMALL
}