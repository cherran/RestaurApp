package dev.cherran.restaurapp.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import dev.cherran.restaurapp.R
import dev.cherran.restaurapp.fragment.TableDetailFragment
import dev.cherran.restaurapp.model.Tables
import kotlinx.android.synthetic.main.activity_table_detail.*

class TableDetailActivity : AppCompatActivity() {
    companion object {

        val EXTRA_TABLE = "EXTRA_TABLE"

        fun intent(context: Context, tableIndex: Int): Intent {
            val intent = Intent(context, TableDetailActivity::class.java)
            intent.putExtra(EXTRA_TABLE, tableIndex)

            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_detail)

        setSupportActionBar(toolbar) // Para hacer que la toolbar haga de ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // botón de "atrás" en la toolbar


        // Obtengo el índice de la tabla de mesas que se ha pulsado para invocar a esta actividad
        val position = intent.getIntExtra(EXTRA_TABLE, 0)

        // Compruebo que el fragment no esté añadido ya
        if (supportFragmentManager.findFragmentById(R.id.table_detail_fragment)  == null) {
            // Añado el Fragment
            val fragment: TableDetailFragment =  TableDetailFragment.newInstance(position)

            supportFragmentManager.beginTransaction()
                    .add(R.id.table_detail_fragment, fragment)
                    .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean = when (item?.itemId) {
        android.R.id.home -> { // flecha de atrás de la toolbar
            finish()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
}
