package com.example.ejemplobd

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoPersona {
    @Query("SELECT * FROM persona")
    fun getAll():List<Persona>
    @Query("SELECT * FROM persona Where nombre like :nombreArgs Limit 1")
    fun findByName(nombreArgs: String): Persona?
    @Insert
    fun agregar(vararg persona: Persona)
    @Query("SELECT * FROM persona WHERE id = :id")
    fun buscar(id: Int): Persona?
}