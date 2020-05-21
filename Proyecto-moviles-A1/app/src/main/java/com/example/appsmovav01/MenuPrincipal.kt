package com.example.appsmovav01

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.example.appsmovav01.ui.Trending.Favoritos2
import com.example.appsmovav01.ui.Trending.TrendingFragment
import com.example.appsmovav01.ui.Trending.TrendingViewModel
import com.example.appsmovav01.ui.gallery.GalleryFragment
import com.example.appsmovav01.ui.home.HomeFragment
import com.example.appsmovav01.ui.profile.Profile
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.nav_header_menu_principal.view.*


class MenuPrincipal : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
//, NavigationView.OnNavigationItemSelectedListener

    private lateinit var appBarConfiguration: AppBarConfiguration




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.appsmovav01.R.layout.activity_menu_principal)
        val toolbar: Toolbar = findViewById(com.example.appsmovav01.R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(com.example.appsmovav01.R.id.drawer_layout)
        val navView: NavigationView = findViewById(com.example.appsmovav01.R.id.nav_view)
        /*val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_favorites,
                R.id.nav_trending,
                R.id.nav_profile,
                R.id.nav_search,
                R.id.nav_logout
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)*/



        var bundle = intent.extras
        if(bundle != null){
            var usuario = bundle.getString("usuario")

            navView.getHeaderView(0).tv_usuario.setText(usuario)
            //txt_perfil.setText(usuario)
        }

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, com.example.appsmovav01.R.string.navigation_drawer_open, com.example.appsmovav01.R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)


    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(com.example.appsmovav01.R.menu.menu_principal, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(com.example.appsmovav01.R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(com.example.appsmovav01.R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            com.example.appsmovav01.R.id.nav_logout -> {
                finish()

            }
            else -> super.onOptionsItemSelected(item)
        }

        return super.onOptionsItemSelected(item)
    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        val fragmentManager = supportFragmentManager

        if (id == com.example.appsmovav01.R.id.nav_home) {
            fragmentManager.beginTransaction().replace(com.example.appsmovav01.R.id.contenedor, HomeFragment()).commit()
        } else if (id == com.example.appsmovav01.R.id.nav_trending) {
            fragmentManager.beginTransaction().replace(com.example.appsmovav01.R.id.contenedor, TrendingFragment()).commit()
        } else if (id == com.example.appsmovav01.R.id.nav_profile) {
            fragmentManager.beginTransaction().replace(com.example.appsmovav01.R.id.contenedor, Profile()).commit()
        } else if (id == com.example.appsmovav01.R.id.nav_favorites) {
            fragmentManager.beginTransaction().replace(com.example.appsmovav01.R.id.contenedor, Favoritos2()).commit()
        }else if (id == com.example.appsmovav01.R.id.nav_search) {
            fragmentManager.beginTransaction().replace(com.example.appsmovav01.R.id.contenedor, GalleryFragment()).commit()
        }
        val drawerLayout: DrawerLayout = findViewById(com.example.appsmovav01.R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

}