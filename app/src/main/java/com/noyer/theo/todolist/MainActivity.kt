package com.noyer.theo.todolist.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Button
import android.widget.EditText
import com.noyer.theo.todolist.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    // Initializing an empty ArrayList to be filled with tasks
    val tasks: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mValidButton = findViewById<Button>(R.id.activity_main_valid_btn)
        var mTaskInput = findViewById<EditText>(R.id.activity_main_task_input)

        mValidButton.isEnabled = false

        // Loads tasks into the ArrayList
        addTasks()

        // Creates a vertical Layout Manager
        rv_task_list.layoutManager = LinearLayoutManager(this)

        // You can use GridLayoutManager if you want multiple columns. Enter the number of columns as a parameter.
        //rv_task_list.layoutManager = GridLayoutManager(this, 2)

        // Access the RecyclerView Adapter and load the data into it
        rv_task_list.adapter = TaskAdapter(tasks, this)

    }

    // Adds tasks to the empty tasks ArrayList
    fun addTasks() {
        tasks.add("ménage")
        tasks.add("sport")
        tasks.add("jardin")
        tasks.add("ménage")
        tasks.add("vaisselle")
        tasks.add("cinéma")
        tasks.add("factures")
        tasks.add("bricolage")
    }

}

