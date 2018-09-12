package dev.cherran.restaurapp.model

import dev.cherran.restaurapp.R

object Dishes { // Singleton
    private val dishes: List<Dish> = listOf(
            Dish("Fingers de Pollo",
                    "Fingers de pollo Cornflakes con salsa BBQ Chipotle o salsa Mostaza & Miel.",
                    R.drawable.fingers,
                    arrayOf(Allergens.GLUTEN),
                    9.50f,
                    null),

            Dish("Quesadilla",
                    "Dos tortillas de harina de trigo, jamón York, queso Cheddar fundido, pico de gallo, crema agria y guacamole.",
                    R.drawable.quesadillas,
                    arrayOf(Allergens.GLUTEN, Allergens.LACTEOS),
                    10.50f,
                    null),

            Dish("Hamburgesa Completa",
                    "Doble hamburguesa de vacuno gallego con quesos americano y cheddar fundidos, bacon ahumado crujiente, cebolla roja a la plancha, pepinillo y salsa BBQ ahumada sobre pan brioche. Acompañada de salsa baconesa y guarnición.",
                    R.drawable.hamburguesa,
                    arrayOf(Allergens.GLUTEN, Allergens.LACTEOS),
                    13.90f,
                    null),

            Dish("Arroz con Verduras y Langostinos",
                    "Langostinos salteados sobre una base de arroz con verduras y salsa Sriracha.",
                    R.drawable.arroz_langostinos,
                    arrayOf(Allergens.MARISCO),
                    12.25f,
                    null),

            Dish("Brownie",
                    "Bizcocho caliente de chocolate, con nueces, cubierto por un helado de vainilla y chocolate fundido.",
                    R.drawable.brownie,
                    arrayOf(Allergens.GLUTEN, Allergens.FRUTOS_SECOS),
                    7.90f,
                    null),

            Dish("Tarta de Queso",
                    "Tarta de crema de queso, base de galleta y una capa de mermelada de fresas",
                    R.drawable.cheesecake,
                    arrayOf(Allergens.GLUTEN, Allergens.LACTEOS),
                    9.50f,
                    null)

            )


    operator fun get(index: Int) = dishes[index]

    val count
        get() = dishes.size

    fun getIndex(dish: Dish): Int = dishes.indexOf(dish)

    fun toArray() = dishes.toTypedArray()

    fun getAllDishes(): List<Dish> = dishes
}