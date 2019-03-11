package com.noyer.theo.todolist.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.noyer.theo.todolist.DatabaseHandler
import com.noyer.theo.todolist.R
import com.noyer.theo.todolist.Task
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity(){

    //Initialisation d'une ArrayList vide à remplir avec des tâches
    val tasks: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //initialisation des variables
        var mTaskInput = findViewById<EditText>(R.id.activity_main_task_input)
        var mValidButton = findViewById<Button>(R.id.activity_main_valid_btn)

        mValidButton.isEnabled = false

        //fonction qui s'applique lors du changement de texte dans la variable mTaskInput
        mTaskInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            //Bouton inactif si pas de texte
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                mValidButton.isEnabled = s.toString().isNotEmpty()
            }

            override fun afterTextChanged(s: Editable) {

            }
        })

        /*mValidButton.setOnClickListener({
            if (mTaskInput.text.toString().isNotEmpty()){
                var task = Task(mTaskInput.text.toString())
                var db = DatabaseHandler(context)
            } else {
                Toast.makeText(this, "Please fill all data", Toast.LENGTH_SHORT.show())
            }
        })*/



        // appel de la fonction pour afficher la liste des taches
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

