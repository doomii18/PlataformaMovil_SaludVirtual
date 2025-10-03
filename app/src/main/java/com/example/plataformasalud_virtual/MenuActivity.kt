package com.example.plataformasalud_virtual

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class MenuActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var toolbar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        drawerLayout = findViewById(R.id.drawerLayout)
        navView = findViewById(R.id.navigationView)
        toolbar = findViewById(R.id.toolbar)

        // Toolbar como ActionBar
        setSupportActionBar(toolbar)

        // Toggle hamburguesa
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Mostrar por defecto el  nuevo fragmento de inicio en lugar de la listaFragment.
        supportFragmentManager.beginTransaction()
            .replace(R.id.contentFrame, InicioFragment())
            .commit()
        supportActionBar?.title = "Inicio"

        // Selección del menú
        navView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.Iniciobtn -> {//carga el nuevo fragmento del inicio layout personalizado
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contentFrame, InicioFragment())
                        .commit()
                    supportActionBar?.title = "Inicio"
                }


                R.id.ConsultasMONGODB -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contentFrame, ListaFragment.newInstance("A"))
                        .commit()
                    supportActionBar?.title = "Consultas  MongoDB"
                }


                R.id.ReportesMedicoCubo -> {                    // Aquí cargamos el fragmento de reportes gerencial/listadebotones  INVENTADOS PPOR EL MOMENTO EN EL AREA DE endopoints ... en lugar de consultas al cubo
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contentFrame, TableroGerencialFragment())
                        .commit()
                    supportActionBar?.title = "Reporte Gerencial"
                }


                R.id.CerrarSesion -> {
                    // diálogo de confirmación
                    val builder = androidx.appcompat.app.AlertDialog.Builder(this)
                    builder.setTitle("Cerrar Sesión")
                    builder.setMessage("¿Estás seguro de que deseas cerrar sesión?")
                    builder.setPositiveButton("Sí") { dialog, _ ->
                        // Ir al login y cerrar la actividad actual
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    builder.setNegativeButton("No") { dialog, _ ->
                        dialog.dismiss() // cerrar el diálogo
                    }
                    builder.show()
                }

            }

            drawerLayout.closeDrawers()
            true
        }
    }
}
