package dev.cherran.restaurapp.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import dev.cherran.restaurapp.R
import dev.cherran.restaurapp.adapter.CellFormat
import dev.cherran.restaurapp.model.Allergens
import dev.cherran.restaurapp.model.Dish
import dev.cherran.restaurapp.model.Dishes
import dev.cherran.restaurapp.model.Tables
import kotlinx.android.synthetic.main.fragment_table_detail.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_TABLE = "ARG_TABLE"



class TableDetailFragment : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance(tableIndex: Int) =
                TableDetailFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_TABLE, tableIndex)
                    }
                }
    }


    private var tableIndex: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            tableIndex = it.getInt(ARG_TABLE, 0)
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_table_detail, container, false)




//        if (view.findViewById<ViewGroup>(R.id.table_list_fragment) != null) { // Hay FrameLayout
//            // Compruebo que el fragment no esté añadido ya
//            if (supportFragmentManager.findFragmentById(R.id.table_list_fragment)  == null) { // Se puede hacer con savedInstanceState == null
//                // Añado el Fragment de forma dinámica
//                val fragment: TableListFragment =  TableListFragment.newInstance()
//
//                supportFragmentManager.beginTransaction()
//                        .add(R.id.table_list_fragment, fragment)
//                        .commit()
//            }
//        }

//        val childFragment = ChildFragment()
//        val transaction = childFragmentManager.beginTransaction()
//        transaction.replace(R.id.child_fragment_container, childFragment).commit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val table = Tables.getTable(tableIndex!!)

        table_name?.text = table.name
        table_people?.text = getString(R.string.table_people_number_text, table.people)

        if (view.findViewById<ViewGroup>(R.id.table_dish_list_fragment) != null) { // Hay FrameLayout
            // Compruebo que el fragment no esté añadido ya
            if (childFragmentManager.findFragmentById(R.id.table_dish_list_fragment)  == null) { // Se puede hacer con savedInstanceState == null
                // Añado el Fragment de forma dinámica


                val fragment = DishListFragment.newInstance(table.getDishes(), CellFormat.SMALL.ordinal)

                childFragmentManager.beginTransaction()
                        .add(R.id.table_dish_list_fragment, fragment)
                        .commit()
            }
        }
    }

}
