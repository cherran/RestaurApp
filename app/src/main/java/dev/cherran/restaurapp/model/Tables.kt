package dev.cherran.restaurapp.model

object Tables {
    private val tables = listOf<Table>(
            Table("Mesa 1", 4, mutableListOf()),
            Table("Mesa 2", 3, mutableListOf()),
            Table("Mesa 3", 5, mutableListOf()),
            Table("Mesa 4", 7, mutableListOf()),
            Table("Mesa 5", 2, mutableListOf()),
            Table("Mesa 6", 2, mutableListOf()),
            Table("Mesa 7", 1, mutableListOf()),
            Table("Mesa 8", 6, mutableListOf())
    )

    val count
        get() = tables.size

    fun getIndex(table: Table): Int = tables.indexOf(table)

    // Operator Overloading
    operator fun get(index: Int) = tables[index]

    fun getTable(index: Int) = tables[index]

    fun toArray() = tables.toTypedArray()

}