package TaskManager.YaGanaste.Entity.Repository;

import TaskManager.YaGanaste.Entity.Result;
import TaskManager.YaGanaste.Entity.Task;


public interface ITask {
    Result GetAll();
    Result GetById(int idTask);
    Result Delete(int idTask);
    Result Add(Task task);
    Result Update(Task task);
    
}
