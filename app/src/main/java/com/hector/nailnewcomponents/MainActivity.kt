package com.hector.nailnewcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import com.google.android.material.navigation.NavigationView
import com.hector.mylibrary.ToolbarActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ToolbarActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbarToLoad(toolbar as Toolbar)

        setNavDrawer()
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

    override fun onNavigationItemSelected(iten: MenuItem): Boolean {
        //Override this for when click on options, give menu item that has a id for some action, this is interface that help control for tokens of options

        return false
    }
}
