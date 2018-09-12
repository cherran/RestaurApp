package dev.cherran.restaurapp.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dev.cherran.restaurapp.R
import kotlinx.android.synthetic.main.activity_table_detail.*

class DishListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_list)

        setSupportActionBar(toolbar) // Para hacer que la toolbar haga de ActionBar
    }
}
