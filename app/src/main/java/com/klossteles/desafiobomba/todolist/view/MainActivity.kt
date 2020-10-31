package com.klossteles.desafiobomba.todolist.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.klossteles.desafiobomba.R
import com.klossteles.desafiobomba.tarefa.model.Tarefa
import com.klossteles.desafiobomba.todolist.repository.ListaTarefasRepository
import com.klossteles.desafiobomba.todolist.viewmodel.ListaTarefasViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: ListaTarefasViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(
            this,
            ListaTarefasViewModel.ListaTarefasViewModelFactory(ListaTarefasRepository(this))
        ).get(ListaTarefasViewModel::class.java)

        viewModel.tarefas.observe(this, Observer {
            criarLista(it)
        })

        viewModel.obterLista()
    }
    fun criarLista(tarefas: List<Tarefa>) {
        val recyclerView = findViewById<RecyclerView>(R.id.lista)
        val manager = GridLayoutManager(this, 2)

        val toast: Toast? = null

//        val customAdapter = CustomAdapter(tarefas) {
//            toast?.cancel()
//
//            val intent = Intent(this@MainActivity, DetalhesActivity::class.java)
//            intent.putExtra("IMAGEM", it.imagemUrl)
//            intent.putExtra("NOME", it.nome)
//            intent.putExtra("GENERO", it.genero)
//            intent.putExtra("PLANETA", it.localizacao.nome)
//
//            startActivity(intent)
//        }

        recyclerView.apply {
            setHasFixedSize(true)

            layoutManager = manager
//            adapter = customAdapter
        }
    }
}