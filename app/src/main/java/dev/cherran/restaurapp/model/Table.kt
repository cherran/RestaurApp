package dev.cherran.restaurapp.model

data class Table (val name: String, val people: Int, private var dishes: MutableList<Dish>) {
    fun addDish(dish: Dish) = dishes.add(dish)

    fun dishesCount () = dishes.count()

    fun getDishIndex(dish: Dish): Int? = dishes.indexOf(dish)

    fun getDishAtIndex(index: Int): Dish? = dishes.get(index)

}