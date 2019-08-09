package com.hector.nailnewcomponents.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.hector.mylibrary.ToolbarActivity
import com.hector.nailnewcomponents.R
import com.hector.nailnewcomponents.fragments.ArrivalsFragment
import com.hector.nailnewcomponents.fragments.DeparturesFragment
import com.hector.nailnewcomponents.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ToolbarActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbarToLoad(toolbar as Toolbar)

        setNavDrawer()

        fragmentTransaction(HomeFragment())
        navView.menu.getItem(0).isChecked = true
    }

    private fun setNavDrawer() {
        //Configure Navigation Drawer, this is basic mode
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            _toolbar,
            R.string.open_drawer,
            R.string.close_drawer
        ) //-> this is as switch, for hamburg icon's and help to transaction open and close, the two last parameters in for invalid persons, for read app
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
    }

    private fun fragmentTransaction(fragment: Fragment){
        //When click on a option support Fragment Manager change this and pass information in container
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        //Override this for when click on options, give menu item that has a id for some action, this is interface that help control for tokens of options

        when(item.itemId){
            R.id.home -> fragmentTransaction(HomeFragment())
            R.id.nav_departures -> fragmentTransaction(DeparturesFragment())
            R.id.nav_arrivals -> fragmentTransaction(ArrivalsFragment())
        }

        return true
    }
}
