package com.example.plataformasalud_virtual

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MenudeGestion: AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menudegestion)


        drawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        // Habilitar el ícono de navegación (hamburguesa)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.menu)

        // Configurar el listener para abrir el menú
        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START) // Abre el menú lateral
        }

        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_pacientes -> {
                    // Navegar a la actividad Pacientes
                }
                // Agrega más
            }
            drawerLayout.closeDrawers()
            true
        }


        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {

                R.id.nav_pacientes -> {
                    val intent = Intent(this, PacienteActivity::class.java)
                    startActivity(intent)
                }

                R.id.nav_tutores -> {
                    val intent = Intent(this, TutoresActivity::class.java)
                    startActivity(intent)
                }

                R.id.nav_citas -> {
                    val intent = Intent(this, CitasMedicasActivity::class.java)
                    startActivity(intent)
                }

                R.id.nav_area_salud -> {
                    val intent = Intent(this, ÁreadeSaludActivity::class.java)
                    startActivity(intent)
                }

                R.id.nav_historial -> {
                    val intent = Intent(this, HistorialActivity::class.java)
                    startActivity(intent)
                }

                R.id.nav_reportes -> {
                    val intent = Intent(this, ReportesActivity::class.java)
                    startActivity(intent)
                }


            }
            drawerLayout.closeDrawers() // cierra el menú al seleccionar
            true
        }


    }
}