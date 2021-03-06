package dev.cherran.restaurapp.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import dev.cherran.restaurapp.R
import dev.cherran.restaurapp.adapter.CellFormat
import dev.cherran.restaurapp.adapter.DishListAdapter
import dev.cherran.restaurapp.model.Dish
import dev.cherran.restaurapp.model.Dishes


private const val ARG_DISHES = "dishes"
private const val ARG_CELL_FORMAT = "cellFormat"


class DishListFragment : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance(dishes: List<Dish>, cellFormat: Int) =
                DishListFragment().apply {
                    arguments = Bundle().apply {
                        putSerializable(ARG_DISHES, dishes.toTypedArray())
                        putInt(ARG_CELL_FORMAT, cellFormat)
                    }
                }
    }


    // TODO: Rename and change types of parameters
    private var dishes: Array<Dish>? = null
    private var cellFormat: Int? = null
    // private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            dishes = it.getSerializable(ARG_DISHES) as Array<Dish>
            cellFormat = it.getInt(ARG_CELL_FORMAT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dish_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val dishList = view.findViewById<RecyclerView>(R.id.dish_list)

        dishList.adapter = DishListAdapter(dishes!!, CellFormat.SMALL, null)

        // TODO. change spanCount for tablet?
        dishList.layoutManager = GridLayoutManager(activity, 1)

        dishList.itemAnimator = DefaultItemAnimator()

    }


    // TODO: Rename method, update argument and hook method into UI event
//    fun onButtonPressed(uri: Uri) {
//        listener?.onFragmentInteraction(uri)
//    }
//
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (context is OnFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
//        }
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        listener = null
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }


}
