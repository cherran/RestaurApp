package dev.cherran.restaurapp.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import dev.cherran.restaurapp.R
import dev.cherran.restaurapp.model.Tables
import kotlinx.android.synthetic.main.activity_table.*

class TableActivity : AppCompatActivity() {
    companion object {

        val EXTRA_TABLE = "EXTRA_TABLE"

        fun intent(context: Context, tableIndex: Int): Intent {
            val intent = Intent(context, TableActivity::class.java)
            intent.putExtra(EXTRA_TABLE, tableIndex)

            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table)

        setSupportActionBar(toolbar) // Para hacer que la toolbar haga de ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // botón de "atrás" en la toolbar

        val position = intent.getIntExtra(EXTRA_TABLE, 0)
        val table = Tables.getTable(position)

        table_name?.text = table.name
        table_people?.text = getString(R.string.table_people_number_text, table.people)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
        android.R.id.home -> { // flecha de atrás de la toolbar
            finish()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}
