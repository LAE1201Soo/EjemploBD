package com.example.ejemplobd
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Persona(
    @PrimaryKey val Id:Int,
   @ColumnInfo(name = "nombre") val nombre:String,
   @ColumnInfo(name= "telefono ") val Telefono:String
)
