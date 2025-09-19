package com.example.plataformasalud_virtual
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivityLocalAp:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contendor_listados)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListadosFragment())
                .commit()
        }
    }
}
