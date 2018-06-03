package dev.cherran.restaurapp.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SimpleCursorAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

import dev.cherran.restaurapp.R
import dev.cherran.restaurapp.model.Table
import dev.cherran.restaurapp.model.Tables
import kotlinx.android.synthetic.main.fragment_table_list.*
import android.widget.TextView




class TableListFragment : Fragment() {

    companion object {
        fun newInstance () = TableListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_table_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tables = Tables.toArray()

        val adapter = object: ArrayAdapter<Table>(activity,
                android.R.layout.simple_list_item_2, // formato de la celda
                android.R.id.text1, // para que el super.getView(position, convertView, parent) no casque
                tables) {
            // Sobreescribo el getView de este ArrayAdapter para que pueda rellenar celdas de título + subtítulo (simple_list_item_2)
            override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
                val cellView =  super.getView(position, convertView, parent)

                val text1 = cellView.findViewById<View>(android.R.id.text1) as TextView?
                val text2 = cellView.findViewById<View>(android.R.id.text2) as TextView?

                text1?.text = tables[position].name
                text2?.text = activity?.getString(R.string.table_people_number_text, tables[position].people)

                return cellView
            }


        }

        table_list.adapter = adapter

    }


}
