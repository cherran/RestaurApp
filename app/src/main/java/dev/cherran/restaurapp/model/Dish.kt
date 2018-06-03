package dev.cherran.restaurapp.model

import java.util.*


enum class Allergens {
    GLUTEN,
    MARISCO,
    FRUTOS_SECOS,
    LACTEOS
    // TODO: añadir más
}


data class Dish (val name: String, val description: String, val image: Int, val allergens: Array<Allergens>?, val price: Float, val comments: String? ) {


    // Array property in data class. It is recomended to override equals and hashCode methods
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Dish

        if (name != other.name) return false
        if (description != other.description) return false
        if (image != other.image) return false
        if (!Arrays.equals(allergens, other.allergens)) return false
        if (price != other.price) return false
        if (comments != other.comments) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + image
        result = 31 * result + (allergens?.let { Arrays.hashCode(it) } ?: 0)
        result = 31 * result + price.hashCode()
        result = 31 * result + (comments?.hashCode() ?: 0)
        return result
    }

}