package com.klossteles.desafiobomba.todolist.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.klossteles.desafiobomba.R
import com.klossteles.desafiobomba.tarefa.model.Tarefa

class TarefaViewHolder(private val view: View): RecyclerView.ViewHolder(view){
    private val descricao = view.findViewById<TextView>(R.id.txtDescTarefa)
    fun bind(tarefa: Tarefa) {
        descricao.text = tarefa.descricao
    }
}