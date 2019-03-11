package com.noyer.theo.todolist

import android.content.Context
import android.database.sqlite.SQLiteDatabase


abstract class DAOBase(pContext: Context) {

    var db: SQLiteDatabase? = null
        protected set
    protected var mHandler: DatabaseHandler? = null

    init {
        this.mHandler = DatabaseHandler(pContext, NOM, null, VERSION)
    }

    fun open(): SQLiteDatabase? {
        // Pas besoin de fermer la dernière base puisque getWritableDatabase s'en charge
        db = mHandler!!.writableDatabase
        return db
    }

    fun close() {
        db!!.close()
    }

    companion object {
        protected val VERSION = 1
        protected val NOM = "database.db"
    }
}
