package com.noyer.theo.todolist

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version) {

    val TASK_TABLE_DROP = "DROP TABLE IF EXISTS $TASK_TABLE_NAME;"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(TASK_TABLE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(TASK_TABLE_DROP)
        onCreate(db)
    }

    companion object {
        val TASK_KEY = "id"
        val TASK_TITLE = "tâche"

        val TASK_TABLE_NAME = "Tâche"
        val TASK_TABLE_CREATE = "CREATE TABLE " + TASK_TABLE_NAME + " (" +
                TASK_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TASK_TITLE + " TEXT);"
    }

    fun insertData(task: Task){
        val values = ContentValues()
        val db = this.writableDatabase
        values.put(TASK_TITLE, task.title)
        db.insert(TASK_TABLE_NAME,null,values)
        db.close()
    }
}
