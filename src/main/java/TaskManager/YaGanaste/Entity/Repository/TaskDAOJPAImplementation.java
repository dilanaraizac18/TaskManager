/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskManager.YaGanaste.Entity.Repository;

import TaskManager.YaGanaste.Entity.Result;
import TaskManager.YaGanaste.Entity.Status;
import TaskManager.YaGanaste.Entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDAOJPAImplementation implements ITask {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Result GetAll() {
        Result result = new Result();

        try {
            TypedQuery<Task> queryTask = entityManager.createQuery("FROM Task", Task.class);

            List<Task> tasks = queryTask.getResultList();

            result.objects = new ArrayList<>();
            for (Task task : tasks) {
                result.objects.add(task);

            }
            result.correct = true;

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;

    }

    @Override
    public Result GetById(int idTask) {
        Result result = new Result();

        try {

            Task task = entityManager.find(Task.class, idTask);

            if (task != null) {

                result.correct = true;
                result.object = task;
            } else {

                result.correct = false;
                result.errorMessage = "No existe la tarea";
            }

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;

        }

        return result;

    }

    @Override
    @Transactional
    public Result Delete(int idTask) {
        Result result = new Result();

        try {
            Task task = entityManager.find(Task.class, idTask);

            entityManager.remove(task);
            result.correct = true;

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;

        }
        return result;
    }

    @Override
    @Transactional
    public Result Add(Task task) {
        Result result = new Result();

        try {
            Task newtask = new Task();

            newtask.setTittle(task.getTittle());
            newtask.setDescription(task.getDescription());
            Status status = entityManager.find(Status.class, task.Status.IdStatus);
            newtask.Status = status;
//            newtask.Status.setIdStatus(task.getIdTask());

            entityManager.persist(newtask);
            result.correct = true;

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }

    @Override
    @Transactional
    public Result Update(Task task) {
        Result result = new Result();

        try {
            Task newtask = entityManager.find(Task.class, task.getIdTask());

            Status status = entityManager.find(Status.class, task.Status.IdStatus);
            task.Status = status;
            task.setIdTask(newtask.getIdTask());
            task.setCreationDate(newtask.getCreationDate());

            entityManager.merge(task);

            result.correct = true;
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }

}
