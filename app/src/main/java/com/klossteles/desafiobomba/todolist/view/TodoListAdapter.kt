package com.klossteles.desafiobomba.todolist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.klossteles.desafiobomba.R
import com.klossteles.desafiobomba.tarefa.model.Tarefa

class TodoListAdapter(private val dataSet: List<Tarefa>, private val listener: (Tarefa) -> Unit):
    RecyclerView.Adapter<TarefaViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarefa, parent, false)

        return TarefaViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(item)

        holder.itemView.setOnClickListener { listener(item) }
    }
}