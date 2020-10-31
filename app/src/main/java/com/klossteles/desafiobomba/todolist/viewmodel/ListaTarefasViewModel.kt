package com.klossteles.desafiobomba.todolist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.klossteles.desafiobomba.tarefa.model.Tarefa
import com.klossteles.desafiobomba.todolist.repository.ListaTarefasRepository

class ListaTarefasViewModel (
    private val repository: ListaTarefasRepository
): ViewModel() {

    val tarefas = MutableLiveData<List<Tarefa>>()

    fun obterLista() {
        repository.obterLista {
            tarefas.value = it
        }
    }

    class ListaTarefasViewModelFactory(
        private val repository: ListaTarefasRepository
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ListaTarefasRepository(repository) as T
        }
    }
}