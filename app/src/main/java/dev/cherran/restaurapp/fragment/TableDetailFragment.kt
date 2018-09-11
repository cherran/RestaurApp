package dev.cherran.restaurapp.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import dev.cherran.restaurapp.R
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
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val table = Tables.getTable(tableIndex!!)

        table_name?.text = table.name
        table_people?.text = getString(R.string.table_people_number_text, table.people)
    }

}
