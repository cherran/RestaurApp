package dev.cherran.restaurapp.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dev.cherran.restaurapp.R
import dev.cherran.restaurapp.adapter.MainPagerAdapter
import dev.cherran.restaurapp.fragment.TableListFragment
import dev.cherran.restaurapp.model.Table
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TableListFragment.OnTableSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentAdapter = MainPagerAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter

        tabs_main.setupWithViewPager(viewpager_main)
    }


    // OnTableSelectedListener
    override fun onTableSelected(table: Table, position: Int) {
        val intent = TableDetailActivity.intent(this, position)
        startActivity(intent)
    }
}
