package com.example.ejemplobd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class ListaContactos : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ContactoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_contactos)
        recyclerView = findViewById(R.id.rvContactos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ContactoAdapter()

        val db = Room.databaseBuilder(applicationContext,
            AppDataBase::class.java,"contactos").allowMainThreadQueries().build()
        val contactos = db.personaDao().getAll()
        adapter.setContactos(contactos)

        recyclerView.adapter = adapter
    }
    }
