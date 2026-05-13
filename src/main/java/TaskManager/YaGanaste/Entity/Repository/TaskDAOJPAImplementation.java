/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TaskManager.YaGanaste.Entity.Repository;

import TaskManager.YaGanaste.Entity.Result;
import TaskManager.YaGanaste.Entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDAOJPAImplementation implements ITask{
    
    @Autowired
    private EntityManager entityManager;
    

    @Override
    public Result GetAll() {
        Result result = new Result();
        
        try{
             TypedQuery<Task> queryTask = entityManager.createQuery("FROM Task", Task.class);
            
            List<Task> tasks = queryTask.getResultList();
            
            result.objects = new ArrayList<>();
            for (Task task : tasks) {
                result.objects.add(task);
                
            }
            result.correct = true;
            
        } catch(Exception ex){
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        
        return result;
        
    }
    
}
