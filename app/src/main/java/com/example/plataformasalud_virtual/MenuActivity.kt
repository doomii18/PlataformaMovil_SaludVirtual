package com.example.plataformasalud_virtual

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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

        // Mostrar por defecto Lista A
        supportFragmentManager.beginTransaction()
            .replace(R.id.contentFrame, ListaFragment.newInstance("A"))
            .commit()
        supportActionBar?.title = "Pequeños Héroes"

        // Selección del menú
        navView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.Pacientes -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contentFrame, ListaFragment.newInstance("B"))
                        .commit()
                    supportActionBar?.title = "Pacientes Pediatricos"
                }
                R.id.Tutores -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contentFrame, ListaFragment.newInstance("C"))
                        .commit()
                    supportActionBar?.title = "Tutores"
                }
                R.id.CitasMedicas -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contentFrame, ListaFragment.newInstance("D"))
                        .commit()
                    supportActionBar?.title = "Citas Médicas"
                }

                R.id.HistorialMedico -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contentFrame, ListaFragment.newInstance("E"))
                        .commit()
                    supportActionBar?.title = "Historial Médico"
                }
                R.id.PersonalMedico -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contentFrame, ListaFragment.newInstance("F"))
                        .commit()
                    supportActionBar?.title = "Personal Médico"
                }
                R.id.Departamentos -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contentFrame, ListaFragment.newInstance("G"))
                        .commit()
                    supportActionBar?.title = "Departamentos"
                }
                R.id.CargoMedico -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contentFrame, ListaFragment.newInstance("H"))
                        .commit()
                    supportActionBar?.title = "Cargo Médicos"
                }
                R.id.Reportes -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contentFrame, ListaFragment.newInstance("I"))
                        .commit()
                    supportActionBar?.title = "Reportes"
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
