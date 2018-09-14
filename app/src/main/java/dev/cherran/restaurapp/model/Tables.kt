package dev.cherran.restaurapp.model

import dev.cherran.restaurapp.R

object Tables {
    private val tables = listOf<Table>(
            Table("Mesa 1", 4, mutableListOf(
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
                            null),
                    Dish("Brownie",
                            "Bizcocho caliente de chocolate, con nueces, cubierto por un helado de vainilla y chocolate fundido.",
                            R.drawable.brownie,
                            arrayOf(Allergens.GLUTEN, Allergens.FRUTOS_SECOS),
                            7.90f,
                            null)
                    )),
            Table("Mesa 2", 3, mutableListOf()),
            Table("Mesa 3", 5, mutableListOf()),
            Table("Mesa 4", 7, mutableListOf()),
            Table("Mesa 5", 2, mutableListOf()),
            Table("Mesa 6", 2, mutableListOf()),
            Table("Mesa 7", 3, mutableListOf()),
            Table("Mesa 8", 6, mutableListOf()),
            Table("Mesa 9", 6, mutableListOf()),
            Table("Mesa 10", 8, mutableListOf()),
            Table("Mesa 11", 2, mutableListOf()),
            Table("Mesa 12", 1, mutableListOf()),
            Table("Mesa 13", 5, mutableListOf()),
            Table("Mesa 14", 3, mutableListOf())

    )

    val count
        get() = tables.size

    fun getIndex(table: Table): Int = tables.indexOf(table)

    fun getTable(index: Int) = tables[index]

    fun toArray() = tables.toTypedArray()

}