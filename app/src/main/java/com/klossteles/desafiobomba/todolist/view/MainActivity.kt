package com.klossteles.desafiobomba.todolist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.klossteles.desafiobomba.R

class MainActivity : AppCompatActivity() {
    private lateinit var manager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = supportFragmentManager

        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, TodoListFragment())
        transaction.commit()

    }
}