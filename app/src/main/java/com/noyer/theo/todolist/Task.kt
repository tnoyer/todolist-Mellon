package com.noyer.theo.todolist

class Task {
    var id: Long = 0
    var title: String? = null

    constructor(title: String?) {
        this.title = title
    }

    override fun toString(): String {
        return "Task(id=$id, title=$title)"
    }
}


