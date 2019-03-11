package com.noyer.theo.todolist

import android.content.Context

class TaskDAO(pContext: Context) : DAOBase(pContext) {

    /**
     * @param t la tâche à ajouter à la base
     */
    fun ajouter(t: Task) {
        // CODE
    }

    /**
     * @param id l'identifiant du métier à supprimer
     */
    fun supprimer(id: Long) {
        // CODE
    }

    /**
     * @param t la tâche modifié
     */
    fun modifier(t: Task) {
        // CODE
    }

    /**
     * @param id l'identifiant du métier à récupérer
     */
    fun selectionner(id: Long) {
        // CODE
    }

    companion object {
        val TABLE_NAME = "tache"
        val KEY = "id"
        val TITLE = "titre"

        val TABLE_CREATE =
            "CREATE TABLE $TABLE_NAME ($KEY INTEGER PRIMARY KEY AUTOINCREMENT, $TITLE TEXT);"

        val TABLE_DROP = "DROP TABLE IF EXISTS $TABLE_NAME;"
    }
}
