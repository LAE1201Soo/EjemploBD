package com.example.ejemplobd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    lateinit var edid:EditText
    lateinit var edNombre:EditText
    lateinit var edTelefono:EditText
    lateinit var edBuscar:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edid = findViewById(R.id.edId)
        edNombre = findViewById(R.id.edNombre)
        edTelefono = findViewById(R.id.edTelefono)
        edBuscar = findViewById(R.id.edbuscar)
    }
    fun consultar(v:View){
        val intent = Intent(this, ListaContactos::class.java)
        startActivity(intent)

    }
    fun buscarPersona(nombre: String): Persona? {
        val db = Room.databaseBuilder(applicationContext,
            AppDataBase::class.java, "contactos").allowMainThreadQueries().build()
        return db.personaDao().findByName(nombre)
    }

    fun buscar(v:View){
        val nombre = edBuscar.text.toString()
        val personaEncontrada = buscarPersona(nombre)
        if(personaEncontrada != null){
            edid.setText(personaEncontrada.Id.toString())
            edNombre.setText(personaEncontrada.nombre)
            edTelefono.setText(personaEncontrada.Telefono)
            Toast.makeText(this,"se encontro",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,"no se encontro",Toast.LENGTH_LONG).show()
        }
    }


    fun agregarDato(v:View){
        val id = edid.text.toString().toInt()
        val nombre = edNombre.text.toString()


        val telefono = edTelefono.text.toString()


        val persona = Persona(id,nombre,telefono)

        val db = Room.databaseBuilder(applicationContext,
        AppDataBase::class.java,"contactos").allowMainThreadQueries().build()
        db.personaDao().agregar(persona)
        Toast.makeText(this,"segrabo",Toast.LENGTH_LONG).show()

    }
}