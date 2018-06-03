package dev.cherran.restaurapp.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import dev.cherran.restaurapp.R
import dev.cherran.restaurapp.fragment.TableListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (findViewById<ViewGroup>(R.id.table_list_fragment) != null) { // Hay FrameLayout para un TableListFragment
            // Compruebo que el fragment no esté añadido ya
            if (supportFragmentManager.findFragmentById(R.id.table_list_fragment)  == null) { // Se puede hacer con savedInstanceState == null
                // Añado el Fragment de forma dinámica
                val fragment: TableListFragment =  TableListFragment.newInstance()

                supportFragmentManager.beginTransaction()
                        .add(R.id.table_list_fragment, fragment)
                        .commit()
            }
        }
    }
}
