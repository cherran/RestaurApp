package dev.cherran.restaurapp.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import dev.cherran.restaurapp.fragment.DishListFragment
import dev.cherran.restaurapp.fragment.TableListFragment


class MainPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                TableListFragment()
            }
            else -> {
                DishListFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Mesas"
            else -> {
                "Menú"
            }
        }
    }
}