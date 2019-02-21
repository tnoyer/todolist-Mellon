'use strict'

const Task = use('App/Models/Task')
const { validate } = use('Validator')

class TaskController {

  //fonction affichant la liste des tâches
  async index ({ view }) {

    const tasks = await Task.all()
    return view.render('tasks.index', { tasks: tasks.toJSON() })
  }

  //fonction permettant d'ajouter une tache
  async store ({ request, response, session }) {

    // validation du formulaire
    const validation = await validate(request.all(), {
      title: 'required|min:2|max:255'
    })

    // message error si echec validation
    if (validation.fails()) {
      session.withErrors(validation.messages())
      .flashAll()

      return response.redirect('back')
    }

    // enregistrer dans la bdd
    const task = new Task()
    task.title = request.input('title')
    await task.save()

    // message de succes
    session.flash({ notification: 'Tâche ajoutée!' })

    return response.redirect('back')
  }

  //fonction permettant de supprimer une tache
  async destroy ({ params, session, response }) {
    const task = await Task.find(params.id)
    await task.delete()

    // message de succes
    session.flash({ notification: 'Tâche supprimée!' })

    return response.redirect('back')
  }
}

module.exports = TaskController
