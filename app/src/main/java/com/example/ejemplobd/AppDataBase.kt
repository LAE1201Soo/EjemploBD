package com.example.ejemplobd
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities =[Persona::class],version=1,exportSchema = false)
abstract class AppDataBase:RoomDatabase(){
    abstract fun personaDao():DaoPersona
}