package com.example.ejemplobd

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactoAdapter : RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>() {

    private var contactos: List<Persona> = listOf()

    fun setContactos(contactos: List<Persona>) {
        this.contactos = contactos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_contacto, parent, false)
        return ContactoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
        val contacto = contactos[position]
        holder.bind(contacto)
    }

    override fun getItemCount(): Int = contactos.size

    inner class ContactoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvId: TextView = itemView.findViewById(R.id.tvId)
        private val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        private val tvTelefono: TextView = itemView.findViewById(R.id.tvTelefono)

        fun bind(contacto: Persona) {
            tvId.text = contacto.Id.toString()
            tvNombre.text = contacto.nombre
            tvTelefono.text = contacto.Telefono
        }
    }
}
